package com.test.FootballNice.mappers;

import com.test.FootballNice.dtos.EquipeDto;
import com.test.FootballNice.dtos.JoueurDto;
import com.test.FootballNice.entities.Equipe;
import com.test.FootballNice.entities.Joueur;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T15:49:17+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class EquipeMapperImpl implements EquipeMapper {

    @Override
    public EquipeDto toDTO(Equipe equipe) {
        if ( equipe == null ) {
            return null;
        }

        EquipeDto equipeDto = new EquipeDto();

        equipeDto.setAcronym( equipe.getAcronym() );
        if ( equipe.getBudget() != null ) {
            equipeDto.setBudget( equipe.getBudget() );
        }
        equipeDto.setId( equipe.getId() );
        equipeDto.setJoueurs( joueurListToJoueurDtoList( equipe.getJoueurs() ) );
        equipeDto.setName( equipe.getName() );

        return equipeDto;
    }

    @Override
    public Equipe toEntity(EquipeDto equipeDto) {
        if ( equipeDto == null ) {
            return null;
        }

        Equipe equipe = new Equipe();

        equipe.setAcronym( equipeDto.getAcronym() );
        equipe.setBudget( equipeDto.getBudget() );
        equipe.setId( equipeDto.getId() );
        equipe.setJoueurs( joueurDtoListToJoueurList( equipeDto.getJoueurs() ) );
        equipe.setName( equipeDto.getName() );

        return equipe;
    }

    protected JoueurDto joueurToJoueurDto(Joueur joueur) {
        if ( joueur == null ) {
            return null;
        }

        JoueurDto joueurDto = new JoueurDto();

        joueurDto.setId( joueur.getId() );
        joueurDto.setName( joueur.getName() );
        joueurDto.setPosition( joueur.getPosition() );

        return joueurDto;
    }

    protected List<JoueurDto> joueurListToJoueurDtoList(List<Joueur> list) {
        if ( list == null ) {
            return null;
        }

        List<JoueurDto> list1 = new ArrayList<JoueurDto>( list.size() );
        for ( Joueur joueur : list ) {
            list1.add( joueurToJoueurDto( joueur ) );
        }

        return list1;
    }

    protected Joueur joueurDtoToJoueur(JoueurDto joueurDto) {
        if ( joueurDto == null ) {
            return null;
        }

        Joueur joueur = new Joueur();

        joueur.setId( joueurDto.getId() );
        joueur.setName( joueurDto.getName() );
        joueur.setPosition( joueurDto.getPosition() );

        return joueur;
    }

    protected List<Joueur> joueurDtoListToJoueurList(List<JoueurDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Joueur> list1 = new ArrayList<Joueur>( list.size() );
        for ( JoueurDto joueurDto : list ) {
            list1.add( joueurDtoToJoueur( joueurDto ) );
        }

        return list1;
    }
}
