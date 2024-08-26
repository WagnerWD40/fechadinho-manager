package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Conhecido;
import br.edu.infnet.appWagnerLemos.model.service.ConhecidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/conhecido")
public class ConhecidoController implements ResourceController<Conhecido> {

    private final ConhecidoService conhecidoService;

    public ConhecidoController(ConhecidoService conhecidoService) {
        this.conhecidoService = conhecidoService;
    }

    @Override
    public Collection<Conhecido> getList() {
        return conhecidoService.getList();
    }

    @Override
    public Conhecido getById(@PathVariable Long id) {
        return conhecidoService.getById(id);
    }

    @Override
    public Long getTotal() {
        return conhecidoService.getQuantidade();
    }

    @Override
    public Conhecido create(@RequestBody Conhecido conhecido) {
        return conhecidoService.create(conhecido);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        conhecidoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
