package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Conhecido;
import br.edu.infnet.appWagnerLemos.model.service.ConhecidoService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/conhecido")
public class ConhecidoController implements ResourceController<Conhecido> {

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
    public Conhecido create(@RequestBody Conhecido conhecido) {
        return conhecidoService.create(conhecido);
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        conhecidoService.delete(id);

        return "Sucesso";
    }
}
