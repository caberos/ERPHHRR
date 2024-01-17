package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Equipment;
import com.diplomado.springboot.dto.EquipmentDTO;

public class EquipmentMapper implements CustomMapper<EquipmentDTO, Equipment>{
    @Override
    public EquipmentDTO toDto(Equipment equipment) {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setId(equipment.getId());
        equipmentDTO.setBrand(equipment.getBrand());
        equipmentDTO.setType(equipment.getType());
        equipmentDTO.setName(equipment.getName());
        equipmentDTO.setDescription(equipment.getDescription());
        equipmentDTO.setPositions(equipment.getPositions());
        return equipmentDTO;
    }

    @Override
    public Equipment toEntity(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        equipment.setId(equipmentDTO.getId());
        equipment.setBrand(equipmentDTO.getBrand());
        equipment.setDescription(equipmentDTO.getDescription());
        equipment.setName(equipmentDTO.getName());
        equipment.setType(equipmentDTO.getType());
        equipment.setPositions(equipmentDTO.getPositions());
        return equipment;
    }
}
