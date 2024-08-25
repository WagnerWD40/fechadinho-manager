package br.edu.infnet.appWagnerLemos;

import br.edu.infnet.appWagnerLemos.model.domain.Rota;
import br.edu.infnet.appWagnerLemos.model.service.RotaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class RotaLoader implements ApplicationRunner {

    private String FILENAME = "files/rota.txt";

    private RotaService service;

    public RotaLoader(RotaService service) {
        this.service = service;
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

        System.out.println(service.getList());
    }

    private void extract(String line) {
        Rota model = Rota.fromFile(line);
        service.create(model);
    }
}
