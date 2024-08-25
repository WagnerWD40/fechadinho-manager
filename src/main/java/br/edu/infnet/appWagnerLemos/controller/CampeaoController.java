package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Campeao;
import br.edu.infnet.appWagnerLemos.model.service.CampeaoService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/campeao")
public class CampeaoController implements ResourceController<Campeao> {

    private final CampeaoService campeaoService;

    public CampeaoController(CampeaoService campeaoService) {
        this.campeaoService = campeaoService;
    }


    @Override
    public Collection<Campeao> getList() {
        return campeaoService.getList();
    }

    @Override
    public Campeao getById(Long id) {
        return campeaoService.getById(id);
    }

    @Override
    public Campeao create(Campeao campeao) {
        return campeaoService.create(campeao);
    }

    @Override
    public String delete(Long id) {
        campeaoService.delete(id);

        return "Campeão criado com sucesso!";
    }
}
