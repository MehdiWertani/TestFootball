package com.test.FootballNice.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @InjectMocks
    private Joueur joueur;

    @Mock
    private Equipe equipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testJoueurGettersAndSetters() {
        // Arrange
        Long id = 1L;
        String name = "Lionel Messi";
        String position = "Forward";
        Equipe equipe = new Equipe();

        // Act
        joueur.setId(id);
        joueur.setName(name);
        joueur.setPosition(position);
        joueur.setEquipe(equipe);

        // Assert
        assertEquals(id, joueur.getId());
        assertEquals(name, joueur.getName());
        assertEquals(position, joueur.getPosition());
        assertEquals(equipe, joueur.getEquipe());
    }

    @Test
    void testJoueurNoArgsConstructor() {
        // Arrange & Act
        Joueur newJoueur = new Joueur();

        // Assert
        assertNotNull(newJoueur);
        assertNull(newJoueur.getId());
        assertNull(newJoueur.getName());
        assertNull(newJoueur.getPosition());
        assertNull(newJoueur.getEquipe());
    }

    @Test
    void testJoueurAllArgsConstructor() {
        // Arrange
        Long id = 1L;
        String name = "Cristiano Ronaldo";
        String position = "Forward";
        Equipe equipe = new Equipe();

        // Act
        Joueur newJoueur = new Joueur(id, name, position, equipe);

        // Assert
        assertEquals(id, newJoueur.getId());
        assertEquals(name, newJoueur.getName());
        assertEquals(position, newJoueur.getPosition());
        assertEquals(equipe, newJoueur.getEquipe());
    }

    @Test
    void testJoueurToString() {
        // Arrange
        Long id = 1L;
        String name = "Neymar Jr";
        String position = "Forward";
        Equipe equipe = new Equipe();

        joueur.setId(id);
        joueur.setName(name);
        joueur.setPosition(position);
        joueur.setEquipe(equipe);

        // Act
        String toStringResult = joueur.toString();

        // Assert
        assertTrue(toStringResult.contains("id=" + id));
        assertTrue(toStringResult.contains("name=" + name));
        assertTrue(toStringResult.contains("position=" + position));
        assertTrue(toStringResult.contains("equipe=" + equipe));
    }

    @Test
    void testJoueurEquipeRelationship() {
        // Arrange
        Long id = 1L;
        String name = "Kylian Mbappé";
        String position = "Forward";
        Equipe equipe = new Equipe();
        equipe.setId(1L);
        equipe.setName("Paris Saint-Germain");

        // Act
        joueur.setId(id);
        joueur.setName(name);
        joueur.setPosition(position);
        joueur.setEquipe(equipe);

        // Assert
        assertEquals(equipe, joueur.getEquipe());
        assertNotNull(joueur.getEquipe().getName());
        assertEquals("Paris Saint-Germain", joueur.getEquipe().getName());
    }
}