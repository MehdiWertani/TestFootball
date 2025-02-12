package com.test.FootballNice.repositories;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.test.FootballNice.entities.Equipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Query("SELECT e FROM Equipe e JOIN FETCH e.joueurs WHERE e.id = :id")
    Optional<Equipe> findEquipeWithJoueurs(@Param("id") Long id);


}
