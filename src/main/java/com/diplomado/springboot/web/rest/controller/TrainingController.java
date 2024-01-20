package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.TrainingDTO;
import com.diplomado.springboot.services.TrainingServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/training")
public class TrainingController {
    private final TrainingServices trainingServices;

    public TrainingController(TrainingServices trainingServices) {
        this.trainingServices = trainingServices;
    }


    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<TrainingDTO>> getTrainings() {
        return ResponseEntity.ok().body(trainingServices.listTrainings());
    }

    @GetMapping(path = "/get/{id}")
    public TrainingDTO getTrainingById(@PathVariable("id") Integer id) {
        return trainingServices.getTraining(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<TrainingDTO> createTraining(@Valid @RequestBody TrainingDTO trainingDTO) throws URISyntaxException {
        if (trainingDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(trainingServices.createTraining(trainingDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<TrainingDTO> updateTraining(@PathVariable("id") Integer id,
                                                          @RequestBody TrainingDTO trainingDTO) {
        if (trainingDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(trainingServices.updateTraining(id, trainingDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<TrainingDTO> deleteTraining(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(trainingServices.deleteTraining(id));
    }
}
