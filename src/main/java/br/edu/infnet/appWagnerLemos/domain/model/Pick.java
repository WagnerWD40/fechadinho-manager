package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Pick extends Entity {
    private Jogador jogador;
    private Campeao campeao;
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
                Integer.valueOf(fields[4]),
                Integer.valueOf(fields[5]),
                Integer.valueOf(fields[6]),
                Integer.valueOf(fields[7]),
                Integer.valueOf(fields[8]),
                Integer.valueOf(fields[9]),
                Integer.valueOf(fields[10])
        );
    }
}
