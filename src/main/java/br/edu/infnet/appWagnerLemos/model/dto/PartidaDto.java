package br.edu.infnet.appWagnerLemos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDto {
    private LocalDate data;
    private LocalTime duracao;
    private boolean vitoriaTimeAzul;

    private List<EquipeDto> equipes = new ArrayList<>();
}
