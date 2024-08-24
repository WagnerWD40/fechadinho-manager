package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.domain.model.Campeao;
import br.edu.infnet.appWagnerLemos.service.CampeaoService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/campeao")
public class CampeaoController {

    private CampeaoService campeaoService;

    public CampeaoController(CampeaoService campeaoService) {
        this.campeaoService = campeaoService;
    }

    @GetMapping("/listar")
    public Collection<Campeao> getList() {
        return campeaoService.getList();
    }

    @GetMapping("/{id}")
    public Campeao getById(@PathVariable Long id) {
        return campeaoService.getById(id);
    }

    @PostMapping
    public Campeao create(@RequestBody Campeao campeao) {
        return campeaoService.create(campeao);
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        campeaoService.delete(id);

        return "Sucesso";
    }
}
