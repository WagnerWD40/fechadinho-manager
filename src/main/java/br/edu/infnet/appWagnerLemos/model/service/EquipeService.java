package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Equipe;
import br.edu.infnet.appWagnerLemos.model.repository.EquipeRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipeService extends BaseService<Equipe, EquipeRepository> {

    public EquipeService(CrudRepository<Equipe, Long> repository) {
        super(repository);
    }
}
