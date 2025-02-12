package com.test.FootballNice.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.FootballNice.dtos.JoueurDto;
import com.test.FootballNice.services.JoueurService;

/**
 * Contrôleur pour l'entité Joueur.
 */
@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {
    private static final Logger logger = LoggerFactory.getLogger(JoueurController.class);
    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    /**
     * Récupérer tous les joueurs.
     */
    @GetMapping
    public ResponseEntity<Page<JoueurDto>> getAllJoueurs(
            /**
             * Paramètre de pagination.
             */
            @RequestParam(defaultValue = "0") int page,
            /**
             * Paramètre de taille de page.
             */
            @RequestParam(defaultValue = "10") int size,
            /**
             * Paramètre de tri.
             */
            @RequestParam(defaultValue = "name") String sort) {
        logger.info("Fetching all joueurs with page: {}, size: {}, sort: {}", page, size, sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<JoueurDto> joueurs = joueurService.getAllJoueurs(pageable);
        return ResponseEntity.ok(joueurs);
    }

    /**
     * Récupérer un joueur par son identifiant.
     */
    @GetMapping("/{id}")
    public ResponseEntity<JoueurDto> getJoueurById(@PathVariable Long id) {
        logger.info("Fetching joueur with id: {}", id);
        JoueurDto joueurDTO = joueurService.getJoueurById(id);
        return ResponseEntity.ok(joueurDTO);
    }

    /**
     * Créer un nouveau joueur.
     */
    @PostMapping
    public ResponseEntity<JoueurDto> createJoueur(@RequestBody JoueurDto joueurDTO) {
        logger.info("Creating new joueur with details: {}", joueurDTO);
        JoueurDto savedJoueur = joueurService.createJoueur(joueurDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJoueur);
    }
}
