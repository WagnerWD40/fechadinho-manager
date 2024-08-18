package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Convidado extends Jogador {
    private String origemContato;

    public Convidado(String nickname, Rota rotasMain, String origemContato) {
        super(nickname, rotasMain);
        this.origemContato = origemContato;
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
                fields[2]
        );
    }
}
