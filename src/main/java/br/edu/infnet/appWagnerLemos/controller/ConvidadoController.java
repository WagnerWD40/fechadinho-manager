package br.edu.infnet.appWagnerLemos.controller;

import br.edu.infnet.appWagnerLemos.model.domain.Convidado;
import br.edu.infnet.appWagnerLemos.model.service.ConvidadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/convidado")
public class ConvidadoController implements ResourceController<Convidado> {

    private final ConvidadoService convidadoService;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @Override
    public Collection<Convidado> getList() {
        return convidadoService.getList();
    }

    @Override
    public Convidado getById(@PathVariable Long id) {
        return convidadoService.getById(id);
    }

    @Override
    public Long getTotal() {
        return convidadoService.getQuantidade();
    }

    @Override
    public Convidado create(@RequestBody Convidado convidado) {
        return convidadoService.create(convidado);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        convidadoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
