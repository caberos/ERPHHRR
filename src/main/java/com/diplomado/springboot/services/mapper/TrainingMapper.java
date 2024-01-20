package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Training;
import com.diplomado.springboot.dto.TrainingDTO;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper implements CustomMapper<TrainingDTO, Training>{
    @Override
    public TrainingDTO toDto(Training training) {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setTrainingId(training.getTrainingId());
        trainingDTO.setName(training.getName());
        trainingDTO.setEmployee(training.getEmployee());
        trainingDTO.setType(training.getType());
        trainingDTO.setDescription(training.getDescription());
        trainingDTO.setStartAt(training.getStartAt());
        trainingDTO.setEndAt(training.getEndAt());
        return trainingDTO;
    }

    @Override
    public Training toEntity(TrainingDTO trainingDTO) {
        Training training = new Training();
        training.setTrainingId(trainingDTO.getTrainingId());
        training.setName(trainingDTO.getName());
        training.setEmployee(trainingDTO.getEmployee());
        training.setType(trainingDTO.getType());
        training.setDescription(trainingDTO.getDescription());
        training.setStartAt(trainingDTO.getStartAt());
        training.setEndAt(trainingDTO.getEndAt());
        return training;
    }
}
