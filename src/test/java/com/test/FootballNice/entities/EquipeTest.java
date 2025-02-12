package com.test.FootballNice.entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipeTest {

    @InjectMocks
    private Equipe equipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEquipeGettersAndSetters() {
        // Arrange
        Long id = 1L;
        String name = "Paris Saint-Germain";
        String acronym = "PSG";
        Double budget = 5000000.0;
        List<Joueur> joueurs = new ArrayList<>();

        // Act
        equipe.setId(id);
        equipe.setName(name);
        equipe.setAcronym(acronym);
        equipe.setBudget(budget);
        equipe.setJoueurs(joueurs);

        // Assert
        assertEquals(id, equipe.getId());
        assertEquals(name, equipe.getName());
        assertEquals(acronym, equipe.getAcronym());
        assertEquals(budget, equipe.getBudget());
        assertEquals(joueurs, equipe.getJoueurs());
    }

    @Test
    void testEquipeNoArgsConstructor() {
        // Arrange & Act
        Equipe newEquipe = new Equipe();

        // Assert
        assertNotNull(newEquipe);
        assertNull(newEquipe.getId());
        assertNull(newEquipe.getName());
        assertNull(newEquipe.getAcronym());
        assertNull(newEquipe.getBudget());
        assertNotNull(newEquipe.getJoueurs());
        assertTrue(newEquipe.getJoueurs().isEmpty());
    }

    @Test
    void testEquipeAllArgsConstructor() {
        // Arrange
        Long id = 1L;
        String name = "Real Madrid";
        String acronym = "RM";
        Double budget = 10000000.0;
        List<Joueur> joueurs = new ArrayList<>();

        // Act
        Equipe newEquipe = new Equipe(id, name, acronym, joueurs, budget);

        // Assert
        assertEquals(id, newEquipe.getId());
        assertEquals(name, newEquipe.getName());
        assertEquals(acronym, newEquipe.getAcronym());
        assertEquals(budget, newEquipe.getBudget());
        assertEquals(joueurs, newEquipe.getJoueurs());
    }

    @Test
    void testEquipeToString() {
        // Arrange
        Long id = 1L;
        String name = "FC Barcelona";
        String acronym = "FCB";
        Double budget = 7500000.0;
        List<Joueur> joueurs = new ArrayList<>();

        equipe.setId(id);
        equipe.setName(name);
        equipe.setAcronym(acronym);
        equipe.setBudget(budget);
        equipe.setJoueurs(joueurs);

        // Act
        String toStringResult = equipe.toString();

        // Assert
        assertTrue(toStringResult.contains("id=" + id));
        assertTrue(toStringResult.contains("name=" + name));
        assertTrue(toStringResult.contains("acronym=" + acronym));
        assertTrue(toStringResult.contains("budget=" + budget));
        assertTrue(toStringResult.contains("joueurs=" + joueurs));
    }
}