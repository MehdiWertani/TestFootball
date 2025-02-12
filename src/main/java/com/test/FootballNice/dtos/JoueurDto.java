package com.test.FootballNice.dtos;

import lombok.Getter;
import lombok.Setter;
 /**
    * DTO pour l'entité Joueur.
 */
@Getter
@Setter
public class JoueurDto {
    private Long id;
    private String name;
    private String position;

}
