package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}
