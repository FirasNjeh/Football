package tn.esprit.football.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.football.Entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}
