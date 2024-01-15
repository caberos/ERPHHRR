package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}
