package com.diplomado.springboot.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_ci")
    private Integer employeeCi;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "equipment_id")
    private Integer equipmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private Integer salary;

    public Position(Integer id, Integer employeeCi,
                    Integer departmentId, Integer equipmentId, String name, String description, Integer salary) {
        this.id = id;
        this.employeeCi = employeeCi;
        this.departmentId = departmentId;
        this.equipmentId = equipmentId;
        this.name = name;
        this.description = description;
        this.salary = salary;
    }

    public Position() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeCi() {
        return employeeCi;
    }

    public void setEmployeeCi(Integer employeeCi) {
        this.employeeCi = employeeCi;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

