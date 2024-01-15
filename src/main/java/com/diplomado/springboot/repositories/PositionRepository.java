package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
