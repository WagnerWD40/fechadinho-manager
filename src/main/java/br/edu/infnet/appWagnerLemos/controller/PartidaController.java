package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Equipe;
import br.edu.infnet.appWagnerLemos.model.domain.Partida;
import br.edu.infnet.appWagnerLemos.model.dto.PartidaDto;
import br.edu.infnet.appWagnerLemos.model.service.EquipeService;
import br.edu.infnet.appWagnerLemos.model.service.PartidaService;
import br.edu.infnet.appWagnerLemos.model.service.PickService;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    private final PartidaService partidaService;
    private final PickService pickService;
    private final EquipeService equipeService;


    public PartidaController(PartidaService partidaService, PickService pickService, EquipeService equipeService) {
        this.partidaService = partidaService;
        this.pickService = pickService;
        this.equipeService = equipeService;
    }

    @GetMapping("/listar")
    public Collection<Partida> getList() {
        return partidaService.getList();
    }

    @GetMapping("/{id}")
    public Partida getById(@PathVariable Long id) {
        return partidaService.getById(id);
    }

    @GetMapping("/total")
    public Long getTotal() {
        return partidaService.getQuantidade();
    }

    @PostMapping
    @Transactional
    public Partida create(@RequestBody PartidaDto partidaDto) {
        List<Equipe> equipes = partidaDto.getEquipes()
                                        .stream()
                                        .map(e -> Equipe.fromDto(e, e.getPicks()
                                                                        .stream()
                                                                        .map(pickService::create)
                                        .toList())).toList();

        List<Equipe> persistedEquipes = equipes.stream().map(e -> equipeService.create(e)).toList();

        Partida partida = Partida.fromDto(partidaDto, persistedEquipes);

        return partidaService.create(partida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        partidaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
