package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Convidado;
import br.edu.infnet.appWagnerLemos.model.service.ConvidadoService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/convidado")
public class ConvidadoController implements ResourceController<Convidado> {

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
    public Convidado create(@RequestBody Convidado convidado) {
        return convidadoService.create(convidado);
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        convidadoService.delete(id);

        return "Sucesso";
    }
}
