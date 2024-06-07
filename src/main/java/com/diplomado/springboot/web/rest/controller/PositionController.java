package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.PositionDTO;
import com.diplomado.springboot.services.PositionServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/position")
@Tag(name = "Posicion de Empleado")
public class PositionController {
    private final PositionServices positionServices;

    public PositionController(PositionServices positionServices) {
        this.positionServices = positionServices;
    }


    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de posiciones de todos los empleados")
    public ResponseEntity<List<PositionDTO>> getPositions() {
        return ResponseEntity.ok().body(positionServices.listPositions());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene la lista de posiciones del empleado")
    public PositionDTO getPositionById(@PathVariable("id") Integer id) {
        return positionServices.getPosition(id);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea una posicion de un empleado")
    public ResponseEntity<PositionDTO> createPosition(@Valid @RequestBody PositionDTO positionDTO) throws URISyntaxException {
        if (positionDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(positionServices.createPosition(positionDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza la posicion de un empleado")
    public ResponseEntity<PositionDTO> updatePosition(@PathVariable("id") Integer id,
                                                          @RequestBody PositionDTO positionDTO) {
        if (positionDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(positionServices.updatePosition(id, positionDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina la posicion de un empleado")
    public ResponseEntity<PositionDTO> deletePosition(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(positionServices.deletePosition(id));
    }
}
