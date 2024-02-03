package com.diplomado.springboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    @JsonIgnore
    private Equipment equipment;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private Integer salary;
    public Position(Integer id, Employee employee, String name, String description, Integer salary,
                    Department department, Equipment equipment) {
        this.id = id;
        this.employee = employee;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.department = department;
        this.equipment = equipment;
    }

    public Position() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

