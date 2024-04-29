package tn.esprit.football.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.football.Entities.Division;
import tn.esprit.football.Entities.Joueur;
import tn.esprit.football.Entities.Poste;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur,Integer> {
    List<Joueur> findByPosteAndTailleGreaterThan(Poste poste, float taille);
    List<Joueur> findAllByPosteAndEquipeDivisionAndEquipeMatchfootballsIdMatch(Poste poste, Division division,int idMatch);
    List<Joueur> findByPosteAndNbButsEnCarriereGreaterThan(Poste poste,int nbBut);
    List<Joueur> findByPoste(Poste poste);
}
