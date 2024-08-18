package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida extends Entity {

    private List<Equipe> equipes = new ArrayList<>();
    private boolean vitoriaTimeAzul;
    private LocalDate data;
    private LocalTime duracao;

}
