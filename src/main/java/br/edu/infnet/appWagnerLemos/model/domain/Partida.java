package br.edu.infnet.appWagnerLemos.model.domain;

import br.edu.infnet.appWagnerLemos.model.dto.PartidaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "partida")
public class Partida extends ModelEntity {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "partida_equipes",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private List<Equipe> equipes = new ArrayList<>();
    private boolean vitoriaTimeAzul;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime duracao;

    public Partida(List<Equipe> equipes, boolean vitoriaTimeAzul, LocalDate data, LocalTime duracao) {
        this.equipes = equipes;
        this.vitoriaTimeAzul = vitoriaTimeAzul;
        this.data = data;
        this.duracao = duracao;
    }

    public static Partida fromDto(PartidaDto partidaDto, List<Equipe> equipes) {
        return new Partida(equipes, partidaDto.isVitoriaTimeAzul(), partidaDto.getData(), partidaDto.getDuracao());
    }

}
