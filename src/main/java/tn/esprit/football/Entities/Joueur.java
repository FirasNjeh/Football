package tn.esprit.football.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joueur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJoueur;
    private String nom;
    private float taille;
    @Enumerated(EnumType.STRING)
    private Poste poste;
    private boolean blessure;
    private int nbButsEnCarriere;
    @JsonIgnore
    @ManyToOne
    Equipe equipe;
}
