package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Partida;
import br.edu.infnet.appWagnerLemos.model.service.PartidaService;
import jakarta.servlet.http.Part;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/partida")
public class PartidaController implements ResourceController<Partida> {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @Override
    public Collection<Partida> getList() {
        return partidaService.getList();
    }

    @Override
    public Partida getById(@PathVariable Long id) {
        return partidaService.getById(id);
    }

    @Override
    public Long getTotal() {
        return partidaService.getQuantidade();
    }

    @Override
    public Partida create(@RequestBody Partida partida) {
        return partidaService.create(partida);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        partidaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
