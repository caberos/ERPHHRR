package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.LaborHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaborHistoryRepository extends JpaRepository<LaborHistory, Integer> {
}
