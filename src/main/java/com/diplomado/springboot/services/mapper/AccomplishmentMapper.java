package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Accomplishments;
import com.diplomado.springboot.dto.AccomplishmentDTO;
import org.springframework.stereotype.Component;

@Component
public class AccomplishmentMapper implements CustomMapper<AccomplishmentDTO, Accomplishments> {

    @Override
    public AccomplishmentDTO toDto(Accomplishments accomplishments) {
        AccomplishmentDTO accomplishmentDTO = new AccomplishmentDTO();
        accomplishmentDTO.setAccomplishmentId(accomplishments.getAccomplishmentId());
        accomplishmentDTO.setDescription(accomplishments.getDescription());
        accomplishmentDTO.setAccomplishmentDate(accomplishments.getAccomplishmentDate());
        accomplishmentDTO.setEmployee(accomplishments.getEmployee());
        return accomplishmentDTO;
    }

    @Override
    public Accomplishments toEntity(AccomplishmentDTO accomplishmentDTO) {
        Accomplishments accomplishments = new Accomplishments();
        accomplishments.setAccomplishmentId(accomplishmentDTO.getAccomplishmentId());
        accomplishments.setAccomplishmentDate(accomplishmentDTO.getAccomplishmentDate());
        accomplishments.setDescription(accomplishmentDTO.getDescription());
        accomplishments.setEmployee(accomplishmentDTO.getEmployee());
        return accomplishments;
    }
}
