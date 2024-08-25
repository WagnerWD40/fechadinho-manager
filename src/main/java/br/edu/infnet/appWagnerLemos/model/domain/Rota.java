package br.edu.infnet.appWagnerLemos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rota")
public class Rota extends ModelEntity {

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
