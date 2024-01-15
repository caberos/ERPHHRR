package com.diplomado.springboot.dto;

import com.diplomado.springboot.domain.entities.Department;
import com.diplomado.springboot.domain.entities.Employee;
import com.diplomado.springboot.domain.entities.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    private Integer id;

    private Employee employee;

    private String name;

    private String description;

    private Integer salary;

    private Department department;

    private Equipment equipment;
}
