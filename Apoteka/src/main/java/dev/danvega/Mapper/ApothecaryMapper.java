package dev.danvega.Mapper;

import dev.danvega.DTO.ApothecaryDTO;
import dev.danvega.Model.Apotecary;

public class ApothecaryMapper implements MapperInterface<Apotecary, ApothecaryDTO> {

    @Override
    public Apotecary toEntity(ApothecaryDTO dto){
        return new Apotecary(dto.getName(), dto.getAddress());
    }

    @Override
    public ApothecaryDTO toDto(Apotecary entity){
        return new ApothecaryDTO(entity.getName(), entity.getAdress());
    }
}
