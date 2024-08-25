package br.edu.infnet.appWagnerLemos.model.repository;

import br.edu.infnet.appWagnerLemos.model.domain.Partida;
import br.edu.infnet.appWagnerLemos.model.domain.Rota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long> {
}
