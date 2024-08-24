package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Jogador extends Entity {

    private String nickname;
    private Rota rotaMain;

    public Jogador(String nickname, Rota rotaMain) {
        this.nickname = nickname;
        this.rotaMain = rotaMain;
    }

    @Override
    public String toString() {
        return String.format("([%s] - id: %d; nick: %s; rota main: %s;)",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getNickname(),
                this.getRotaMain().toString());
    }
}
