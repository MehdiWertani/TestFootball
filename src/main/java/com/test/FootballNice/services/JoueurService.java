package com.test.FootballNice.services;


import com.test.FootballNice.mappers.JoueurMapper;
import com.test.FootballNice.dtos.JoueurDto;
import com.test.FootballNice.entities.Joueur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.test.FootballNice.repositories.JoueurRepository;

import jakarta.persistence.EntityExistsException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JoueurService {

    private final JoueurRepository joueurRepository;
    private final JoueurMapper joueurMapper;

    public JoueurService(JoueurRepository joueurRepository, JoueurMapper joueurMapper) {
        this.joueurRepository = joueurRepository;
        this.joueurMapper = joueurMapper;
    }

    // Get all players with pagination
    public Page<JoueurDto> getAllJoueurs(Pageable pageable) {
        Page<Joueur> joueurs = joueurRepository.findAll(pageable);
        return joueurs.map(joueurMapper::toDTO);
    }

    // Get a player by ID
    public JoueurDto getJoueurById(Long id) {
        Joueur joueur = joueurRepository.findById(id)
                .orElseThrow(() -> new EntityExistsException("Player not found"));

        return joueurMapper.toDTO(joueur);
    }

    // Create a new player
    public JoueurDto createJoueur(JoueurDto joueurDTO) {
        Joueur joueur = joueurMapper.toEntity(joueurDTO);
        Joueur savedJoueur = joueurRepository.save(joueur);
        return joueurMapper.toDTO(savedJoueur);
    }
}

