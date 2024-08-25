package br.edu.infnet.appWagnerLemos.model.repository;

import br.edu.infnet.appWagnerLemos.model.domain.Campeao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeaoRepository extends CrudRepository<Campeao, Long> {
}
