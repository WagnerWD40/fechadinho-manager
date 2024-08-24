package br.edu.infnet.appWagnerLemos.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime duracao;

}
