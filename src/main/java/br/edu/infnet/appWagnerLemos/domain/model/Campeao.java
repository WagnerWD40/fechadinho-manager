package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Campeao extends Entity {

    private String nome;
    private Integer idRiot;

    public Campeao(String nome, Integer idRiot) {
        this.nome = nome;
        this.idRiot = idRiot;
    }

    @Override
    public String toString() {
        return String.format("([%s] - id: %d; nome: %s; idRiot: %d)", this.getClass().getSimpleName(), id, nome, idRiot);
    }

    public static Campeao fromFile(String line) {
        String[] fields = line.split(";");
        return new Campeao(
                fields[1],
                Integer.valueOf(fields[0])
        );
    }
}
