package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Campeao;
import br.edu.infnet.appWagnerLemos.model.repository.CampeaoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CampeaoService extends BaseService<Campeao, CampeaoRepository> {

    public CampeaoService(CrudRepository<Campeao, Long> repository) {
        super(repository);
    }
}
