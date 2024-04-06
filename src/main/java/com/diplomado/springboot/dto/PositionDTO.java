package com.diplomado.springboot.dto;

import com.diplomado.springboot.domain.entities.Department;
import com.diplomado.springboot.domain.entities.Employee;
import com.diplomado.springboot.domain.entities.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String name;

    private String description;

    private Integer salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
