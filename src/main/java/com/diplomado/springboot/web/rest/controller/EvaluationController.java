package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.EvaluationDTO;
import com.diplomado.springboot.services.DepartmentServices;
import com.diplomado.springboot.services.EvaluationServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/evaluation")
public class EvaluationController {
    private final EvaluationServices evaluationServices;

    public EvaluationController(EvaluationServices evaluationServices) {
        this.evaluationServices = evaluationServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<EvaluationDTO>> getEvaluation() {
        return ResponseEntity.ok().body(evaluationServices.listEvaluation());
    }

    @GetMapping(path = "/get/{id}")
    public EvaluationDTO getEvaluationById(@PathVariable("id") Integer evaluationId) {
        return evaluationServices.getEvaluation(evaluationId);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EvaluationDTO> createEvaluation(@Valid @RequestBody EvaluationDTO evaluationDTO) throws URISyntaxException {
        if (evaluationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(evaluationServices.createEvaluation(evaluationDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<EvaluationDTO> updateEvaluation(@PathVariable("id") Integer evaluationId,
                                                          @RequestBody EvaluationDTO evaluationDTO) {
        if (evaluationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(evaluationServices.updateEvaluation(evaluationId, evaluationDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<EvaluationDTO> deleteEvaluation(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(evaluationServices.deleteEvaluation(id));
    }
}
