package dev.danvega.Mapper;

import dev.danvega.DTO.ApotecaryDTO;
import dev.danvega.DTO.ApothecaryDTO;
import dev.danvega.Model.Apotecary;

public class ApothecaryMapper implements MapperInterface<Apotecary, ApotecaryDTO> {

    @Override
    public Apotecary toEntity(ApotecaryDTO dto){
        return new Apotecary(dto.getName(), dto.getAdress(), dto.getDescription());
    }

    @Override
    public ApotecaryDTO toDto(Apotecary entity){
        return new ApotecaryDTO(entity.getId(), entity.getName(), entity.getAdress(), entity.getDescription(), 0);
    }
}
