package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Position;
import com.diplomado.springboot.domain.entities.Training;
import com.diplomado.springboot.dto.TrainingDTO;
import com.diplomado.springboot.repositories.TrainingRepository;
import com.diplomado.springboot.services.TrainingServices;
import com.diplomado.springboot.services.mapper.TrainingMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingServicesImplement implements TrainingServices {
    private final TrainingMapper trainingMapper;
    private final TrainingRepository trainingRepository;

    public TrainingServicesImplement(TrainingMapper trainingMapper,
                                     TrainingRepository trainingRepository) {
        this.trainingMapper = trainingMapper;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<TrainingDTO> listTrainings() {
        return this.trainingRepository.findAll()
                .stream().map(trainingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TrainingDTO getTraining(Integer id) {
        List<Training> trainingList = trainingRepository.findAll();
        Training res = new Training();
        for (Training aux : trainingList) {
            if (aux.getTrainingId() == id) {
                res = aux;
                break;
            }
        }
        return this.trainingMapper.toDto(res);
    }

    @Override
    public TrainingDTO createTraining(TrainingDTO training) {
        return this.trainingMapper.toDto(
                trainingRepository.save(this.trainingMapper.toEntity(training)));
    }

    @Override
    public TrainingDTO updateTraining(Integer id, TrainingDTO trainingDTO) {
        Training training = trainingRepository.getReferenceById(id);
        training.setTrainingId(trainingDTO.getTrainingId());
        training.setName(trainingDTO.getName());
        training.setEmployee(trainingDTO.getEmployee());
        training.setType(trainingDTO.getType());
        training.setDescription(trainingDTO.getDescription());
        training.setStartAt(trainingDTO.getStartAt());
        training.setEndAt(trainingDTO.getEndAt());
        trainingRepository.save(training);
        return this.trainingMapper.toDto(training);
    }

    @Override
    public TrainingDTO deleteTraining(Integer id) {
        List<Training> trainingList = trainingRepository.findAll();
        Training res = new Training();
        for (Training aux : trainingList) {
            if (aux.getTrainingId() == id) {
                res = aux;
                trainingRepository.deleteById(id);
                break;
            }
        }
        return this.trainingMapper.toDto(res);
    }
}
