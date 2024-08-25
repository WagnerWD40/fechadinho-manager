package br.edu.infnet.appWagnerLemos.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jogador")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Jogador extends ModelEntity {

    private String nickname;

    @ManyToOne
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
