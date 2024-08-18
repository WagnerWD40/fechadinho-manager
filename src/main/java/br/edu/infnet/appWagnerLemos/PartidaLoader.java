package br.edu.infnet.appWagnerLemos;

import br.edu.infnet.appWagnerLemos.domain.model.*;
import br.edu.infnet.appWagnerLemos.service.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Order(5)
@Component
public class PartidaLoader implements ApplicationRunner {

    private String FILENAME = "files/partida.txt";

    private PickService pickService;
    private EquipeService equipeService;
    private PartidaService partidaService;
    private ConhecidoService conhecidoService;
    private ConvidadoService convidadoService;
    private RotaService rotaService;
    private CampeaoService campeaoService;

    public PartidaLoader(PickService pickService, EquipeService equipeService, PartidaService partidaService, ConhecidoService conhecidoService, ConvidadoService convidadoService, RotaService rotaService, CampeaoService campeaoService) {
        this.pickService = pickService;
        this.equipeService = equipeService;
        this.partidaService = partidaService;
        this.conhecidoService = conhecidoService;
        this.convidadoService = convidadoService;
        this.rotaService = rotaService;
        this.campeaoService = campeaoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader(FILENAME);
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        ArrayList<Partida> partidas = new ArrayList<>();
        Integer currentPartidaIndex = 0;
        Partida currentPartida = new Partida();
        Equipe currentEquipe = new Equipe();

        while (line != null) {

            String[] fields = line.split(";");

            String infoType = fields[0];

            if (infoType.equals("M")) {
                currentPartida.setVitoriaTimeAzul(Boolean.valueOf(fields[1]));
                currentPartida.setData(LocalDate.parse(fields[2]));
                currentPartida.setDuracao(LocalTime.parse(fields[3], formatter));
            }

            if (infoType.equals("E")) {
                currentEquipe.setSide(fields[1]);
                currentEquipe.setDragao(Integer.valueOf(fields[2]));
                currentEquipe.setBarao(Integer.valueOf(fields[3]));
                currentEquipe.setHerald(Integer.valueOf(fields[4]));
                currentEquipe.setGrub(Integer.valueOf(fields[5]));
                currentEquipe.setTorre(Integer.valueOf(fields[6]));
                currentEquipe.setInibidor(Integer.valueOf(fields[7]));
            }

            if (infoType.equals("P")) {
                Jogador jogador = conhecidoService.getById(Long.valueOf(fields[1]));
                Campeao campeao = campeaoService.getById(Long.valueOf(fields[2]));
                Rota rota = rotaService.getById(Long.valueOf(fields[3]));

                Pick pick = Pick.fromFile(fields, jogador, campeao, rota);
                currentEquipe.getPicks().add(pick);
            }

            if (currentEquipe.getPicks().size() == 5) {
                currentPartida.getEquipes().add(currentEquipe);
                currentEquipe = new Equipe();
            }

            if (currentPartida.getEquipes().size() == 2) {
                partidaService.create(currentPartida);
                currentPartida = new Partida();
            }

            line = reader.readLine();
        }

        System.out.println(partidaService.getList());
    }
}
