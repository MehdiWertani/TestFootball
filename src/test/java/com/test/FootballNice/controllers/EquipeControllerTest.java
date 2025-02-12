package com.test.FootballNice.controllers;

import com.test.FootballNice.dtos.EquipeDto;
import com.test.FootballNice.services.EquipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipeControllerTest {

    @Mock
    private EquipeService equipeService;

    @InjectMocks
    private EquipeController equipeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEquipes() {
        // Arrange
        int page = 0;
        int size = 10;
        String sort = "name";
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(1L);
        equipeDto.setName("Paris Saint-Germain");
        equipeDto.setAcronym("PSG");
        equipeDto.setBudget(5000000.0);

        List<EquipeDto> equipeList = Collections.singletonList(equipeDto);
        Page<EquipeDto> equipePage = new PageImpl<>(equipeList, pageable, equipeList.size());

        when(equipeService.getAllEquipes(pageable)).thenReturn(equipePage);

        // Act
        ResponseEntity<Page<EquipeDto>> response = equipeController.getAllEquipes(page, size, sort);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getTotalElements());
        assertEquals(equipeDto, response.getBody().getContent().get(0));

        verify(equipeService, times(1)).getAllEquipes(pageable);
    }

    @Test
    void testGetEquipeById() {
        // Arrange
        Long id = 1L;
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(id);
        equipeDto.setName("Real Madrid");
        equipeDto.setAcronym("RM");
        equipeDto.setBudget(10000000.0);

        when(equipeService.getEquipeById(id)).thenReturn(equipeDto);

        // Act
        ResponseEntity<EquipeDto> response = equipeController.getEquipeById(id);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(equipeDto, response.getBody());

        verify(equipeService, times(1)).getEquipeById(id);
    }

    @Test
    void testCreateEquipe() {
        // Arrange
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setName("FC Barcelona");
        equipeDto.setAcronym("FCB");
        equipeDto.setBudget(7500000.0);

        EquipeDto savedEquipe = new EquipeDto();
        savedEquipe.setId(1L);
        savedEquipe.setName(equipeDto.getName());
        savedEquipe.setAcronym(equipeDto.getAcronym());
        savedEquipe.setBudget(equipeDto.getBudget());

        when(equipeService.createEquipe(equipeDto)).thenReturn(savedEquipe);

        // Act
        ResponseEntity<EquipeDto> response = equipeController.createEquipe(equipeDto);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(savedEquipe, response.getBody());

        verify(equipeService, times(1)).createEquipe(equipeDto);
    }
}