package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Position;
import com.diplomado.springboot.dto.PositionDTO;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper implements CustomMapper<PositionDTO, Position>{
    @Override
    public PositionDTO toDto(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setName(position.getName());
        positionDTO.setDepartment(position.getDepartment());
        positionDTO.setEmployee(position.getEmployee());
        positionDTO.setEquipment(position.getEquipment());
        positionDTO.setSalary(position.getSalary());
        positionDTO.setDescription(position.getDescription());
        return positionDTO;
    }

    @Override
    public Position toEntity(PositionDTO positionDTO) {
        Position position = new Position();
        position.setId(positionDTO.getId());
        position.setName(positionDTO.getName());
        position.setDepartment(positionDTO.getDepartment());
        position.setEmployee(positionDTO.getEmployee());
        position.setEquipment(positionDTO.getEquipment());
        position.setSalary(positionDTO.getSalary());
        position.setDescription(positionDTO.getDescription());
        return position;
    }
}
