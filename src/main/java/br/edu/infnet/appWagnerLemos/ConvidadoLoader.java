package br.edu.infnet.appWagnerLemos;

import br.edu.infnet.appWagnerLemos.domain.model.Conhecido;
import br.edu.infnet.appWagnerLemos.domain.model.Convidado;
import br.edu.infnet.appWagnerLemos.domain.model.Rota;
import br.edu.infnet.appWagnerLemos.service.ConhecidoService;
import br.edu.infnet.appWagnerLemos.service.ConvidadoService;
import br.edu.infnet.appWagnerLemos.service.RotaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class ConvidadoLoader implements ApplicationRunner {

    private String FILENAME = "files/convidado.txt";

    private ConvidadoService convidadoService;
    private RotaService rotaService;

    public ConvidadoLoader(ConvidadoService convidadoService, RotaService rotaService) {
        this.convidadoService = convidadoService;
        this.rotaService = rotaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader(FILENAME);
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        while (line != null) {
            extract(line);
            line = reader.readLine();
        }

        System.out.println(convidadoService.getList());
    }

    private void extract(String line) {
        String[] splittedLine = line.split(";");

        Rota rota = rotaService.getById(Long.valueOf(splittedLine[1]));

        Convidado model = Convidado.fromFile(splittedLine, rota);

        convidadoService.create(model);
    }
}
