package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Rota;
import br.edu.infnet.appWagnerLemos.model.repository.RotaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RotaService extends BaseService<Rota, RotaRepository> {

    public RotaService(CrudRepository<Rota, Long> repository) {
        super(repository);
    }
}
