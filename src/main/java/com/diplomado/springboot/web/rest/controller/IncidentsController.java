package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.IncidentsDTO;
import com.diplomado.springboot.services.IncidentsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/incidents")
@Tag(name = "Incidentes de Empleado")
public class IncidentsController {
    private final IncidentsServices incidentsServices;

    public IncidentsController(IncidentsServices incidentsServices) {
        this.incidentsServices = incidentsServices;
    }


    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de incidentes de todos los empleados")
    public ResponseEntity<List<IncidentsDTO>> getIncidents() {
        return ResponseEntity.ok().body(incidentsServices.listIncidents());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene el incidente de un empleado")
    public IncidentsDTO getIncidentsById(@PathVariable("id") Integer incidentId) {
        return incidentsServices.getIncident(incidentId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea un incidente de un empleado")
    public ResponseEntity<IncidentsDTO> createIncident(@Valid @RequestBody IncidentsDTO incidentsDTO) throws URISyntaxException {
        if (incidentsDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(incidentsServices.createIncident(incidentsDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza un incidente de un empleado")
    public ResponseEntity<IncidentsDTO> updateIncident(@PathVariable("id") Integer incidentId,
                                                          @RequestBody IncidentsDTO incidentsDTO) {
        if (incidentsDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(incidentsServices.updateIncident(incidentId, incidentsDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina un incidente de un empleado")
    public ResponseEntity<IncidentsDTO> deleteContact(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(incidentsServices.deleteIncident(id));
    }
}
