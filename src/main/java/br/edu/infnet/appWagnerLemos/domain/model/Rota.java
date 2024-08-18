package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.Data;

@Data
public class Rota extends Entity {

    public String nome;

    public Rota(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("([%s] - id: %d; nome: %s)", this.getClass().getSimpleName(), id, nome);
    }

    public static Rota fromFile(String line) {
        String[] fields = line.split(";");
        return new Rota(fields[0]);
    }
}
