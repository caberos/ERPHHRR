package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.EquipmentDTO;
import com.diplomado.springboot.services.EquipmentServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/equipment")
@Tag(name = "Equipamiento de la empresa")
public class EquipmentController {
    private final EquipmentServices equipmentServices;

    public EquipmentController(EquipmentServices equipmentServices) {
        this.equipmentServices = equipmentServices;
    }

    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de los equipamiento de la empresa")
    public ResponseEntity<List<EquipmentDTO>> getEquipaments() {
        return ResponseEntity.ok().body(equipmentServices.listEquipment());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene el equipamiento de la empresa")
    public EquipmentDTO getEquipmentById(@PathVariable("id") Integer equipmentId) {
        return equipmentServices.getEquipment(equipmentId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea un equipamiento de una empresa")
    public ResponseEntity<EquipmentDTO> createEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO) throws URISyntaxException {
        if (equipmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(equipmentServices.createEquipment(equipmentDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza un equipamiento de la empresa")
    public ResponseEntity<EquipmentDTO> updateEquipment(@PathVariable("id") Integer equipmentId,
                                                          @RequestBody EquipmentDTO equipmentDTO) {
        if (equipmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(equipmentServices.updateEquipment(equipmentId, equipmentDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina el equipamiento de la empresa")
    public ResponseEntity<EquipmentDTO> deleteEquipment(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(equipmentServices.deleteEquipment(id));
    }
}
