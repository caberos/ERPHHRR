package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Equipment;
import com.diplomado.springboot.domain.entities.Evaluation;
import com.diplomado.springboot.dto.EvaluationDTO;
import com.diplomado.springboot.repositories.EvaluationRepository;
import com.diplomado.springboot.services.EvaluationServices;
import com.diplomado.springboot.services.mapper.EvaluationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationServicesImplement implements EvaluationServices {

    private final EvaluationMapper evaluationMapper;
    private final EvaluationRepository evaluationRepository;

    public EvaluationServicesImplement(EvaluationMapper evaluationMapper,
                                       EvaluationRepository evaluationRepository) {
        this.evaluationMapper = evaluationMapper;
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public List<EvaluationDTO> listEvaluation() {
        return this.evaluationRepository.findAll()
                .stream().map(evaluationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EvaluationDTO getEvaluation(Integer id) {
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        Evaluation res = new Evaluation();
        for (Evaluation aux : evaluationList) {
            if (aux.getEvaluationId() == id) {
                res = aux;
                break;
            }
        }
        return this.evaluationMapper.toDto(res);
    }

    @Override
    public EvaluationDTO createEvaluation(EvaluationDTO evaluation) {
        return this.evaluationMapper.toDto(
                evaluationRepository.save(this.evaluationMapper.toEntity(evaluation)));
    }

    @Override
    public EvaluationDTO updateEvaluation(Integer id, EvaluationDTO evaluationDTO) {
        Evaluation evaluation = evaluationRepository.getReferenceById(Long.valueOf(id));
        evaluation.setEvaluationId(evaluationDTO.getEvaluationId());
        evaluation.setComments(evaluationDTO.getComments());
        evaluation.setEmployee(evaluationDTO.getEmployee());
        evaluation.setScore(evaluationDTO.getScore());
        evaluation.setYear(evaluationDTO.getYear());
        evaluation.setEvalTime(evaluationDTO.getEvalTime());
        evaluation.setTimeScale(evaluationDTO.getTimeScale());
        evaluationRepository.save(evaluation);
        return this.evaluationMapper.toDto(evaluation);
    }

    @Override
    public EvaluationDTO deleteEvaluation(Integer id) {
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        Evaluation res = new Evaluation();
        for (Evaluation aux : evaluationList) {
            if (aux.getEvaluationId() == id) {
                res = aux;
                evaluationRepository.deleteById(Long.valueOf(id));
                break;
            }
        }
        return this.evaluationMapper.toDto(res);
    }
}
