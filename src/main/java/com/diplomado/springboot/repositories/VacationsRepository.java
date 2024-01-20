package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Vacations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationsRepository extends JpaRepository<Vacations, Long> {
}
