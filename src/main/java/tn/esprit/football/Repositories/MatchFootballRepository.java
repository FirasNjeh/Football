package tn.esprit.football.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.football.Entities.MatchFootball;

public interface MatchFootballRepository extends JpaRepository<MatchFootball,Integer> {
}
