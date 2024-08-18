package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.Data;

@Data
public class Campeao extends Entity {

    private String nome;

    public Campeao(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("([%s] - id: %d; nome: %s)", this.getClass().getSimpleName(), id, nome);
    }

    public static Campeao fromFile(String line) {
        String[] fields = line.split(";");
        return new Campeao(
                fields[0]
        );
    }
}
