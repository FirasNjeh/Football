package tn.esprit.football.Service;

import org.springframework.format.annotation.DateTimeFormat;
import tn.esprit.football.Entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IService {
    public Equipe ajouterEquipe (Equipe equipe);
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe);
    public List<Joueur> afficherJoueursParPosteEtTaille (Poste poste, float taille);
    public MatchFootball ajouterMatchFootballEtAffecterEquipe
            (MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2);
    public List <Joueur> afficherJoueursDuMatchParDivisionEtPoste (Division division,
                                                                   Poste poste, Integer idMatch);
    public void afficherJoueursPolyvalentsDisponibles ();
    public MatchFootball reporterMatch(Integer idMatch, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateReportee);




}
