package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.EquipmentDTO;

import java.util.List;

public interface EquipmentServices {

    List<EquipmentDTO> listEquipment();
    EquipmentDTO getEquipment(Integer id);
    EquipmentDTO createEquipment(EquipmentDTO equipment);
    EquipmentDTO updateEquipment(Integer id, EquipmentDTO equipment);
    EquipmentDTO deleteEquipment(Integer id);
}
