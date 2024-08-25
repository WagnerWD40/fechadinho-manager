package br.edu.infnet.appWagnerLemos.model.repository;

import br.edu.infnet.appWagnerLemos.model.domain.Conhecido;
import br.edu.infnet.appWagnerLemos.model.domain.Convidado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
}
