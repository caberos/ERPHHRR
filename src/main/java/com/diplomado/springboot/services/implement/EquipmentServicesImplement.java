package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Department;
import com.diplomado.springboot.domain.entities.Equipment;
import com.diplomado.springboot.dto.EquipmentDTO;
import com.diplomado.springboot.repositories.EquipmentRepository;
import com.diplomado.springboot.services.EquipmentServices;
import com.diplomado.springboot.services.mapper.EquipmentMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentServicesImplement implements EquipmentServices {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public EquipmentServicesImplement(EquipmentRepository equipmentRepository,
                                      EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    @Override
    public List<EquipmentDTO> listEquipment() {
        return this.equipmentRepository.findAll()
                .stream().map(equipmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EquipmentDTO getEquipment(Integer id) {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        Equipment res = new Equipment();
        for (Equipment aux : equipmentList) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
        }
        return this.equipmentMapper.toDto(res);
    }

    @Override
    public EquipmentDTO createEquipment(EquipmentDTO equipment) {
        return this.equipmentMapper.toDto(
                equipmentRepository.save(this.equipmentMapper.toEntity(equipment)));
    }

    @Override
    public EquipmentDTO updateEquipment(Integer id, EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentRepository.getReferenceById(id);
        equipment.setId(equipmentDTO.getId());
        equipment.setBrand(equipmentDTO.getBrand());
        equipment.setDescription(equipmentDTO.getDescription());
        equipment.setName(equipmentDTO.getName());
        equipment.setType(equipmentDTO.getType());
        equipment.setPositions(equipmentDTO.getPositions());
        equipmentRepository.save(equipment);
        return this.equipmentMapper.toDto(equipment);
    }

    @Override
    public EquipmentDTO deleteEquipment(Integer id) {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        Equipment res = new Equipment();
        for (Equipment aux : equipmentList) {
            if (aux.getId() == id) {
                res = aux;
                equipmentRepository.deleteById(id);
                break;
            }
        }
        return this.equipmentMapper.toDto(res);
    }
}
