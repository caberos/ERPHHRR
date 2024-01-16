package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.TrainingDTO;

import java.util.List;

public interface TrainingServices {
    List<TrainingDTO> listTrainings();

    TrainingDTO getTraining(Integer id);

    TrainingDTO createTraining(TrainingDTO training);

    TrainingDTO updateTraining(Integer id, TrainingDTO training);

    TrainingDTO deleteTraining(Integer id);
}
