package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
