package br.edu.infnet.appWagnerLemos.model.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PickDto {
    private Long conhecidoId;
    private Long convidadoId;
    private Long campeao;
    private Long rota;
    private Integer abates;
    private Integer mortes;
    private Integer assistencias;
    private Integer danoCausado;
    private Integer danoRecebido;
    private Integer gold;
    private Integer cs;
}
