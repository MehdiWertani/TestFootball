package com.test.FootballNice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.FootballNice.entities.Joueur;
 /**
    * Repository pour l'entité Joueur.
 */
@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
}
