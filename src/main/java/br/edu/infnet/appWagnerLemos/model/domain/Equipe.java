package br.edu.infnet.appWagnerLemos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @OneToMany
    private List<Pick> picks = new ArrayList<>();

    private String side;
    private Integer dragao;
    private Integer barao;
    private Integer herald;
    private Integer grub;
    private Integer torre;
    private Integer inibidor;




}
