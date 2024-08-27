package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.Campeao;
import br.edu.infnet.appWagnerLemos.model.domain.Jogador;
import br.edu.infnet.appWagnerLemos.model.domain.Pick;
import br.edu.infnet.appWagnerLemos.model.domain.Rota;
import br.edu.infnet.appWagnerLemos.model.dto.PickDto;
import br.edu.infnet.appWagnerLemos.model.repository.PickRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PickService extends BaseService<Pick, PickRepository> {

    private final RotaService rotaService;
    private final ConhecidoService conhecidoService;
    private final ConvidadoService convidadoService;
    private final CampeaoService campeaoService;

    public PickService(CrudRepository<Pick, Long> repository, RotaService rotaService, ConhecidoService conhecidoService, ConvidadoService convidadoService, CampeaoService campeaoService) {
        super(repository);
        this.rotaService = rotaService;
        this.conhecidoService = conhecidoService;
        this.convidadoService = convidadoService;
        this.campeaoService = campeaoService;
    }

    public Pick create(PickDto pickDto) {
        Jogador jogador = pickDto.getConhecidoId() != null ? conhecidoService.getById(pickDto.getConhecidoId()) : convidadoService.getById(pickDto.getConvidadoId());
        Rota rota = rotaService.getById(pickDto.getRota());
        Campeao campeao = campeaoService.getById(pickDto.getCampeao());

        Pick pick = Pick.fromDto(jogador, rota, campeao, pickDto);

        return repository.save(pick);

    }
}
