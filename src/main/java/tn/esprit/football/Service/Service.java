package tn.esprit.football.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.football.Entities.*;
import tn.esprit.football.Repositories.EquipeRepository;
import tn.esprit.football.Repositories.JoueurRepository;
import tn.esprit.football.Repositories.MatchFootballRepository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Slf4j

@org.springframework.stereotype.Service
public class Service implements IService {
    private EquipeRepository equipeRepository;
    private JoueurRepository joueurRepository;
    private MatchFootballRepository matchFootballRepository;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {
        Equipe eq =equipeRepository.findById(idEquipe).orElse(null);
        joueur.setEquipe(eq);
        return joueurRepository.save(joueur);
    }

    @Override
    public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
        return joueurRepository.findByPosteAndTailleGreaterThan(poste, taille);
    }

    @Override
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2) {
        Equipe eq1=equipeRepository.findById(idEquipe1).orElse(null);
        Equipe eq2=equipeRepository.findById(idEquipe2).orElse(null);
        if(eq1!=eq2) {
            matchFootball.getEquipes().add(eq1);
            matchFootball.getEquipes().add(eq2);
            matchFootballRepository.save(matchFootball);
        }
        return matchFootball;
    }

    @Override
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {

        return joueurRepository.findAllByPosteAndEquipeDivisionAndEquipeMatchfootballsIdMatch(poste,division,idMatch);
    }

    @Override
    //1ere methode
    @Scheduled(fixedRate = 60000)//en millieseconde
    //2eme methode
    //@Scheduled(cron = "*/60 * * * * *")//*loula chaque 60 *thenya seconde minute heure jour mois *jour de la semaine lundi=1
    //sans controller car c'est automatique
    public void afficherJoueursPolyvalentsDisponibles() {
        for(Joueur j :joueurRepository.findByPoste(Poste.DEFENSEUR)){
            if ((j.getNbButsEnCarriere()>20) && j.isBlessure()==false)
                log.info("Le Joueur " +j.getNom()+" est polyvalent");
        }
    }

    @Override
    public MatchFootball reporterMatch(Integer idMatch, LocalDate dateReportee) {
        MatchFootball matchFootball= matchFootballRepository.findById(idMatch).orElse(null);


    }
}
