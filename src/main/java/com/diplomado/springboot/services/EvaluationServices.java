package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.EvaluationDTO;

import java.util.List;

public interface EvaluationServices {

    List<EvaluationDTO> listEvaluation();
    EvaluationDTO getEvaluation(Integer id);
    EvaluationDTO createEvaluation(EvaluationDTO evaluation);
    EvaluationDTO updateEvaluation(Integer id, EvaluationDTO evaluation);
    EvaluationDTO deleteEvaluation(Integer id);
}
