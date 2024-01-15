package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
