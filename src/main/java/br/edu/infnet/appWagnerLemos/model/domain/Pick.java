package br.edu.infnet.appWagnerLemos.model.domain;

import br.edu.infnet.appWagnerLemos.model.dto.PickDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pick")
public class Pick extends ModelEntity {

    @ManyToOne
    private Jogador jogador;

    @ManyToOne
    private Campeao campeao;

    @ManyToOne
    private Rota rota;

    private Integer abates;
    private Integer mortes;
    private Integer assistencias;
    private Integer danoCausado;
    private Integer danoRecebido;
    private Integer gold;
    private Integer cs;

    public Pick(Jogador jogador, Campeao campeao, Rota rota, Integer abates, Integer mortes, Integer assistencias, Integer danoCausado, Integer danoRecebido, Integer gold, Integer cs) {
        this.jogador = jogador;
        this.campeao = campeao;
        this.rota = rota;
        this.abates = abates;
        this.mortes = mortes;
        this.assistencias = assistencias;
        this.danoCausado = danoCausado;
        this.danoRecebido = danoRecebido;
        this.gold = gold;
        this.cs = cs;
    }

    @Override
    public String toString() {
        return "Pick{" +
                "jogador=" + jogador +
                ", campeao=" + campeao +
                ", rota=" + rota +
                ", abates=" + abates +
                ", mortes=" + mortes +
                ", assistencias=" + assistencias +
                ", danoCausado=" + danoCausado +
                ", danoRecebido=" + danoRecebido +
                ", gold=" + gold +
                ", cs=" + cs +
                '}';
    }

    public static Pick fromFile(String[] fields, Jogador jogador, Campeao campeao, Rota rota) {
        return new Pick(
                jogador,
                campeao,
                rota,
                Integer.valueOf(fields[5]),
                Integer.valueOf(fields[6]),
                Integer.valueOf(fields[7]),
                Integer.valueOf(fields[8]),
                Integer.valueOf(fields[9]),
                Integer.valueOf(fields[10]),
                Integer.valueOf(fields[11])
        );
    }

    public static Pick fromDto(Jogador jogador, Rota rota, Campeao campeao, PickDto pickDto) {
        return new Pick(jogador, campeao, rota, pickDto.getAbates(), pickDto.getMortes(), pickDto.getAssistencias(), pickDto.getDanoCausado(), pickDto.getDanoRecebido(), pickDto.getGold(), pickDto.getCs());
    }
}
