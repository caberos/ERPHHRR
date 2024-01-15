package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentsRepository extends JpaRepository<Incidents, Integer> {
}
