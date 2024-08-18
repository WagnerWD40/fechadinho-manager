package br.edu.infnet.appWagnerLemos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipe extends Entity {
    private List<Pick> picks =new ArrayList<>();

    private String side;
    private Integer dragao;
    private Integer barao;
    private Integer herald;
    private Integer grub;
    private Integer torre;
    private Integer inibidor;




}
