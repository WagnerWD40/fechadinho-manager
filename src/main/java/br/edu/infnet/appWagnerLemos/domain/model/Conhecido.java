package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conhecido extends Jogador {
    private String nome;
    private String discord;

    private String whatsapp;

    public Conhecido(String nickname, Rota rotasMain, String nome, String discord, String whatsapp) {
        super(nickname, rotasMain);
        this.nome = nome;
        this.discord = discord;
        this.whatsapp = whatsapp;
    }

    @Override
    public String toString() {
        return String.format("([%s] discord: %s; nome: %s; whatsapp: %s;)",
                super.toString(),
                this.getDiscord(),
                this.getNome(),
                this.getWhatsapp());
    }

    public static Conhecido fromFile(String[] fields, Rota rota) {
        return new Conhecido(
            fields[0],
            rota,
            fields[2],
            fields[3],
            fields[4]
        );
    }
}
