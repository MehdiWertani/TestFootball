package com.test.FootballNice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.test.FootballNice.dtos.EquipeDto;
import com.test.FootballNice.services.EquipeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * 
 * Contrôleur pour l'entité Equipe.
 */
@RestController
@RequestMapping("/api/equipes")
public class EquipeController {
private static final Logger logger = LoggerFactory.getLogger(EquipeController.class);
    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    /**
     * Récupérer toutes les équipes.
     */
    @GetMapping
    public ResponseEntity<Page<EquipeDto>> getAllEquipes(
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
                logger.info("Fetching all equipes with page: {}, size: {}, sort: {}", page, size, sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<EquipeDto> equipes = equipeService.getAllEquipes(pageable);
        return ResponseEntity.ok(equipes);
    }

    /**
     * Récupérer une équipe par son identifiant.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EquipeDto> getEquipeById(@PathVariable Long id) {
        logger.info("Fetching equipe with id: {}", id);
        EquipeDto equipeDTO = equipeService.getEquipeById(id);
        return ResponseEntity.ok(equipeDTO);
    }

    /**
     * Créer une nouvelle équipe.
     */
    @PostMapping
    public ResponseEntity<EquipeDto> createEquipe(@RequestBody EquipeDto equipeDTO) {
        logger.info("Creating new equipe with details: {}", equipeDTO);
        EquipeDto savedEquipe = equipeService.createEquipe(equipeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipe);
    }
}
