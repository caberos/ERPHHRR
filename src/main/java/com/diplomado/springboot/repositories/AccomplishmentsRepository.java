package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Accomplishments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccomplishmentsRepository extends JpaRepository<Accomplishments, Long> {
}
