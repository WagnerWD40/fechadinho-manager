package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Pick;
import br.edu.infnet.appWagnerLemos.model.repository.PickRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PickService extends BaseService<Pick, PickRepository> {
    public PickService(CrudRepository<Pick, Long> repository) {
        super(repository);
    }
}
