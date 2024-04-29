package tn.esprit.football.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MatchFootball implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatch;
    private String libelle;
    private String pays;
    private LocalDate dateMatch;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Equipe> equipes=new ArrayList<>();


}
