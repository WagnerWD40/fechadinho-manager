package br.edu.infnet.appWagnerLemos.model.repository;

import br.edu.infnet.appWagnerLemos.model.domain.Pick;
import br.edu.infnet.appWagnerLemos.model.domain.Rota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickRepository extends CrudRepository<Pick, Long> {
}
