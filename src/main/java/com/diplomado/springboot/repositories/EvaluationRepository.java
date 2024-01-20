package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
