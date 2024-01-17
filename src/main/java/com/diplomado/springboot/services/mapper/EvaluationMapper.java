package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Evaluation;
import com.diplomado.springboot.dto.EvaluationDTO;

public class EvaluationMapper implements CustomMapper<EvaluationDTO, Evaluation>{
    @Override
    public EvaluationDTO toDto(Evaluation evaluation) {
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setEvaluationId(evaluation.getEvaluationId());
        evaluationDTO.setComments(evaluation.getComments());
        evaluationDTO.setEmployee(evaluation.getEmployee());
        evaluationDTO.setScore(evaluation.getScore());
        evaluationDTO.setYear(evaluation.getYear());
        evaluationDTO.setEvalTime(evaluation.getEvalTime());
        evaluationDTO.setTimeScale(evaluation.getTimeScale());
        return evaluationDTO;
    }

    @Override
    public Evaluation toEntity(EvaluationDTO evaluationDTO) {
        Evaluation evaluation = new Evaluation();
        evaluation.setEvaluationId(evaluationDTO.getEvaluationId());
        evaluation.setComments(evaluationDTO.getComments());
        evaluation.setEmployee(evaluationDTO.getEmployee());
        evaluation.setScore(evaluationDTO.getScore());
        evaluation.setYear(evaluationDTO.getYear());
        evaluation.setEvalTime(evaluationDTO.getEvalTime());
        evaluation.setTimeScale(evaluationDTO.getTimeScale());
        return evaluation;
    }
}
