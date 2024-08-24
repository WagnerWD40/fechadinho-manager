package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.domain.model.Conhecido;
import br.edu.infnet.appWagnerLemos.domain.model.Convidado;
import br.edu.infnet.appWagnerLemos.service.ConhecidoService;
import br.edu.infnet.appWagnerLemos.service.ConvidadoService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/convidado")
public class ConvidadoController {

    private final ConvidadoService convidadoService;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @GetMapping(value = "/listar")
    public Collection<Convidado> getList() {
        return convidadoService.getList();
    }

    @GetMapping(value = "/{id}")
    public Convidado getById(@PathVariable Long id) {
        return convidadoService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody Convidado convidado) {
        convidadoService.create(convidado);

        return "Convidado criado com sucesso";
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        convidadoService.delete(id);

        return "Sucesso";
    }
}
