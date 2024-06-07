package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.EvaluationDTO;
import com.diplomado.springboot.services.DepartmentServices;
import com.diplomado.springboot.services.EvaluationServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/evaluation")
@Tag(name = "Evaluaciones de Empleado")
public class EvaluationController {
    private final EvaluationServices evaluationServices;

    public EvaluationController(EvaluationServices evaluationServices) {
        this.evaluationServices = evaluationServices;
    }

    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de evaluaciones de todos los empleados")
    public ResponseEntity<List<EvaluationDTO>> getEvaluation() {
        return ResponseEntity.ok().body(evaluationServices.listEvaluation());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene la evaluacion de un empleado")
    public EvaluationDTO getEvaluationById(@PathVariable("id") Integer evaluationId) {
        return evaluationServices.getEvaluation(evaluationId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea una evaluacion de un empleado")
    public ResponseEntity<EvaluationDTO> createEvaluation(@Valid @RequestBody EvaluationDTO evaluationDTO) throws URISyntaxException {
        if (evaluationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(evaluationServices.createEvaluation(evaluationDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza una evaluacion de un empleado")
    public ResponseEntity<EvaluationDTO> updateEvaluation(@PathVariable("id") Integer evaluationId,
                                                          @RequestBody EvaluationDTO evaluationDTO) {
        if (evaluationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(evaluationServices.updateEvaluation(evaluationId, evaluationDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina una evaluacion de un empleado")
    public ResponseEntity<EvaluationDTO> deleteEvaluation(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(evaluationServices.deleteEvaluation(id));
    }
}
