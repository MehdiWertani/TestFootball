package com.test.FootballNice.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
 /**
    * DTO pour l'entité Equipe.
 */
@Getter
@Setter
public class EquipeDto {
    private Long id;
    private String name;
    private String acronym;
    private double budget;
    private List<JoueurDto> joueurs;

}
