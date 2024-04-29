package tn.esprit.football.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.football.Entities.*;
import tn.esprit.football.Service.IService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/football")
public class ControllerFootball {
    private IService iService;
    @PostMapping("/creerEquipe")
    public Equipe ajouterEquipe(Equipe equipe) {
        return iService.ajouterEquipe(equipe);
    }
    @PostMapping("/creerJoueur")
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {
        return iService.ajouterJoueurEtAffecterEquipe(joueur, idEquipe);
    }
    @GetMapping("/chercherJoueur")
    public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
        return iService.afficherJoueursParPosteEtTaille(poste, taille);
    }

    @PostMapping("/creerMatch")
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2) {
        return iService.ajouterMatchFootballEtAffecterEquipe(matchFootball, idEquipe1, idEquipe2);
    }

    @GetMapping("/chercherMatch")
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {
        return iService.afficherJoueursDuMatchParDivisionEtPoste(division, poste, idMatch);
    }

}
