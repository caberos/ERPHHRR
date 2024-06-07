package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.TrainingDTO;
import com.diplomado.springboot.services.TrainingServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/training")
@Tag(name = "Capacitaciones de Empleado")
public class TrainingController {
    private final TrainingServices trainingServices;

    public TrainingController(TrainingServices trainingServices) {
        this.trainingServices = trainingServices;
    }


    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de capacitaciones de todos los empleados")
    public ResponseEntity<List<TrainingDTO>> getTrainings() {
        return ResponseEntity.ok().body(trainingServices.listTrainings());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene la capacitacion de un empleado")
    public TrainingDTO getTrainingById(@PathVariable("id") Integer id) {
        return trainingServices.getTraining(id);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea una capacitacion de un empleado")
    public ResponseEntity<TrainingDTO> createTraining(@Valid @RequestBody TrainingDTO trainingDTO) throws URISyntaxException {
        if (trainingDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(trainingServices.createTraining(trainingDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza una capacitacion de un empleado")
    public ResponseEntity<TrainingDTO> updateTraining(@PathVariable("id") Integer id,
                                                          @RequestBody TrainingDTO trainingDTO) {
        if (trainingDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(trainingServices.updateTraining(id, trainingDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina una capacitacion de un empleado")
    public ResponseEntity<TrainingDTO> deleteTraining(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(trainingServices.deleteTraining(id));
    }
}
