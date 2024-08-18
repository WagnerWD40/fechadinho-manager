package br.edu.infnet.appWagnerLemos;

import br.edu.infnet.appWagnerLemos.domain.model.Campeao;
import br.edu.infnet.appWagnerLemos.service.CampeaoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(2)
@Component
public class CampeaoLoader implements ApplicationRunner {

    private String FILENAME = "files/campeao.txt";

    private CampeaoService service;

    public CampeaoLoader(CampeaoService service) {
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
        Campeao model = Campeao.fromFile(line);
        service.create(model);
    }
}
