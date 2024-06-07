package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.LaborHistoryDTO;
import com.diplomado.springboot.services.LaborHistoryServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/labor_history")
@Tag(name = "Historial Laboral de Empleado")
public class LaborHistoryController {
    private final LaborHistoryServices laborHistoryServices;

    public LaborHistoryController(LaborHistoryServices laborHistoryServices) {
        this.laborHistoryServices = laborHistoryServices;
    }


    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de los historiales laborales de todos los empleados")
    public ResponseEntity<List<LaborHistoryDTO>> getLaborHistories() {
        return ResponseEntity.ok().body(laborHistoryServices.listLaborHistories());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene el historial laboral de un empleado")
    public LaborHistoryDTO getLaborHistoryById(@PathVariable("id") Integer laborHistoryId) {
        return laborHistoryServices.getLaborHistory(laborHistoryId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea un historial laboral de un empleado")
    public ResponseEntity<LaborHistoryDTO> createLaborHistory(@Valid @RequestBody LaborHistoryDTO laborHistoryDTO) throws URISyntaxException {
        if (laborHistoryDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(laborHistoryServices.createLaborHistory(laborHistoryDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza un historial laboral de un empleado")
    public ResponseEntity<LaborHistoryDTO> updateLaborHistory(@PathVariable("id") Integer laborHistoryId,
                                                          @RequestBody LaborHistoryDTO laborHistoryDTO) {
        if (laborHistoryDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(laborHistoryServices.updateLaborHistory(laborHistoryId, laborHistoryDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina un historial laboral de un empleado")
    public ResponseEntity<LaborHistoryDTO> deleteContact(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(laborHistoryServices.deleteLaborHistory(id));
    }
}
