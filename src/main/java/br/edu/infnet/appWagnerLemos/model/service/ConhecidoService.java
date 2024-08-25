package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Conhecido;
import br.edu.infnet.appWagnerLemos.model.repository.ConhecidoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ConhecidoService extends BaseService<Conhecido, ConhecidoRepository> {
    public ConhecidoService(CrudRepository<Conhecido, Long> repository) {
        super(repository);
    }
}
