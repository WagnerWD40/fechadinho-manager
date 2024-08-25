package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Convidado;
import br.edu.infnet.appWagnerLemos.model.repository.ConvidadoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService extends BaseService<Convidado, ConvidadoRepository> {

    public ConvidadoService(CrudRepository<Convidado, Long> repository) {
        super(repository);
    }
}
