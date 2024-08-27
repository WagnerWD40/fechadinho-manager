package br.edu.infnet.appWagnerLemos.model.domain;

import br.edu.infnet.appWagnerLemos.model.dto.EquipeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "equipe")
public class Equipe extends ModelEntity {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pick> picks = new ArrayList<>();

    private String side;
    private Integer dragao;
    private Integer barao;
    private Integer herald;
    private Integer grub;
    private Integer torre;
    private Integer inibidor;

    public Equipe(List<Pick> picks, String side, Integer dragao, Integer barao, Integer herald, Integer grub, Integer torre, Integer inibidor) {
        this.picks = picks;
        this.side = side;
        this.dragao = dragao;
        this.barao = barao;
        this.herald = herald;
        this.grub = grub;
        this.torre = torre;
        this.inibidor = inibidor;
    }

    public static Equipe fromDto(EquipeDto equipeDto, List<Pick> picks) {
        return new Equipe(picks, equipeDto.getSide(), equipeDto.getDragao(), equipeDto.getBarao(), equipeDto.getHerald(), equipeDto.getGrub(), equipeDto.getTorre(), equipeDto.getInibidor());
    }

}
