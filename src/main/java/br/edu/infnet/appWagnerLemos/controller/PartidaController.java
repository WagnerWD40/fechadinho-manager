package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Partida;
import br.edu.infnet.appWagnerLemos.model.service.PartidaService;
import jakarta.servlet.http.Part;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/partida")
public class PartidaController implements ResourceController<Partida> {

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
    public Partida create(@RequestBody Partida partida) {
        return partidaService.create(partida);
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        partidaService.delete(id);

        return "Sucesso";
    }
}
