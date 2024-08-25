package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Partida;
import br.edu.infnet.appWagnerLemos.model.repository.PartidaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PartidaService extends BaseService<Partida, PartidaRepository> {
    public PartidaService(CrudRepository<Partida, Long> repository) {
        super(repository);
    }
}
