package br.edu.infnet.appWagnerLemos.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipe")
public class Equipe extends ModelEntity {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Pick> picks = new ArrayList<>();

    private String side;
    private Integer dragao;
    private Integer barao;
    private Integer herald;
    private Integer grub;
    private Integer torre;
    private Integer inibidor;




}
