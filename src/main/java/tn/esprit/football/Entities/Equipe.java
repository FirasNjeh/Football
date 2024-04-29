package tn.esprit.football.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEQUIPE;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Division division;
    private String pays;
    @JsonIgnore
    @ManyToMany(mappedBy="equipes", cascade = CascadeType.ALL)
    private List<MatchFootball> matchfootballs;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="equipe")
    private List<Joueur> Joueurs;
}
