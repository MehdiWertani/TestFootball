package com.test.FootballNice.services;

import org.springframework.stereotype.Service;

import com.test.FootballNice.mappers.EquipeMapper;
import com.test.FootballNice.dtos.EquipeDto;
import com.test.FootballNice.entities.Equipe;
import com.test.FootballNice.repositories.EquipeRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class EquipeService {

    private final EquipeRepository equipeRepository;
    private final EquipeMapper equipeMapper; // Injected mapper

    public EquipeService(EquipeRepository equipeRepository, EquipeMapper equipeMapper) {
        this.equipeRepository = equipeRepository;
        this.equipeMapper = equipeMapper;
    }

    // Get all teams with pagination
    public Page<EquipeDto> getAllEquipes(Pageable pageable) {
        // Fetch entities from the repository
        Page<Equipe> equipes = equipeRepository.findAll(pageable);

        // Map entities to DTOs
        return equipes.map(equipeMapper::toDTO);
    }

    // Get a single team by ID
    public EquipeDto getEquipeById(Long id) {
        Equipe equipe = equipeRepository.findEquipeWithJoueurs(id)
                .orElseThrow(() -> new EntityNotFoundException("Équipe non trouvée"));

        // Convert entity to DTO using mapper
        return equipeMapper.toDTO(equipe);
    }

    // Create a new team
    public EquipeDto createEquipe(EquipeDto equipeDTO) {
        // Map DTO to entity
        Equipe equipe = equipeMapper.toEntity(equipeDTO);

        // Save the entity
        Equipe savedEquipe = equipeRepository.save(equipe);

        // Convert the saved entity back to DTO
        return equipeMapper.toDTO(savedEquipe);
    }
}
