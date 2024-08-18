package br.edu.infnet.appWagnerLemos;

import br.edu.infnet.appWagnerLemos.domain.model.Campeao;
import br.edu.infnet.appWagnerLemos.domain.model.Conhecido;
import br.edu.infnet.appWagnerLemos.domain.model.Rota;
import br.edu.infnet.appWagnerLemos.service.ConhecidoService;
import br.edu.infnet.appWagnerLemos.service.RotaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class ConhecidoLoader implements ApplicationRunner {

    private String FILENAME = "files/conhecido.txt";

    private ConhecidoService conhecidoService;
    private RotaService rotaService;

    public ConhecidoLoader(ConhecidoService conhecidoService, RotaService rotaService) {
        this.conhecidoService = conhecidoService;
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

        System.out.println(conhecidoService.getList());
    }

    private void extract(String line) {
        String[] splittedLine = line.split(";");

        Rota rota = rotaService.getById(Long.valueOf(splittedLine[1]));

        Conhecido model = Conhecido.fromFile(splittedLine, rota);

        conhecidoService.create(model);
    }
}
