package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.domain.model.Partida;
import br.edu.infnet.appWagnerLemos.service.PartidaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    private PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping(value = "/listar")
    public Collection<Partida> getList() {
        return partidaService.getList();
    }

    @GetMapping(value = "/{id}")
    public Partida getById(@PathVariable Long id) {
        return partidaService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody Partida partida) {
        partidaService.create(partida);

        return "Partida criada com sucesso";
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        partidaService.delete(id);

        return "Sucesso";
    }
}
