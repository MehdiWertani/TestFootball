package com.test.FootballNice.mappers;

import org.mapstruct.Mapper;

import com.test.FootballNice.dtos.EquipeDto;
import com.test.FootballNice.entities.Equipe;

@Mapper(componentModel = "spring")
public interface EquipeMapper {

    EquipeDto toDTO(Equipe equipe);
    Equipe toEntity(EquipeDto equipeDto);
}
