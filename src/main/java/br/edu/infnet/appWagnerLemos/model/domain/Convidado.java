package br.edu.infnet.appWagnerLemos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Convidado extends Jogador {
    private String origemContato;
    private String rankSolo;

    public Convidado(String nickname, Rota rotasMain, String origemContato, String rankSolo) {
        super(nickname, rotasMain);
        this.origemContato = origemContato;
        this.rankSolo = rankSolo;
    }

    @Override
    public String toString() {
        return String.format("([%s] origem do contato: %s;)",
                super.toString(),
                this.origemContato);
    }

    public static Convidado fromFile(String[] fields, Rota rota) {
        return new Convidado(
                fields[0],
                rota,
                fields[2],
                fields[3]
        );
    }
}
