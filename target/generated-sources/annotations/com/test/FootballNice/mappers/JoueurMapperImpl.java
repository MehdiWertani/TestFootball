package com.test.FootballNice.mappers;

import com.test.FootballNice.dtos.JoueurDto;
import com.test.FootballNice.entities.Joueur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T15:49:17+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class JoueurMapperImpl implements JoueurMapper {

    @Override
    public JoueurDto toDTO(Joueur joueur) {
        if ( joueur == null ) {
            return null;
        }

        JoueurDto joueurDto = new JoueurDto();

        joueurDto.setId( joueur.getId() );
        joueurDto.setName( joueur.getName() );
        joueurDto.setPosition( joueur.getPosition() );

        return joueurDto;
    }

    @Override
    public Joueur toEntity(JoueurDto joueurDto) {
        if ( joueurDto == null ) {
            return null;
        }

        Joueur joueur = new Joueur();

        joueur.setId( joueurDto.getId() );
        joueur.setName( joueurDto.getName() );
        joueur.setPosition( joueurDto.getPosition() );

        return joueur;
    }
}
