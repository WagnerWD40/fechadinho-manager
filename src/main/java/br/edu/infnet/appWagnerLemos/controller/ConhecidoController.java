package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.domain.model.Conhecido;
import br.edu.infnet.appWagnerLemos.domain.model.Partida;
import br.edu.infnet.appWagnerLemos.service.ConhecidoService;
import br.edu.infnet.appWagnerLemos.service.PartidaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/conhecido")
public class ConhecidoController {

    private ConhecidoService conhecidoService;

    public ConhecidoController(ConhecidoService conhecidoService) {
        this.conhecidoService = conhecidoService;
    }

    @GetMapping(value = "/listar")
    public Collection<Conhecido> getList() {
        return conhecidoService.getList();
    }

    @GetMapping(value = "/{id}")
    public Conhecido getById(@PathVariable Long id) {
        return conhecidoService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody Conhecido conhecido) {
        conhecidoService.create(conhecido);

        return "Conhecido criado com sucesso";
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        conhecidoService.delete(id);

        return "Sucesso";
    }
}
