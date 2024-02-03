package com.diplomado.springboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Integer trainingId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "start_at")
    private LocalDateTime startAt;
    @Column(name = "end_at")
    private LocalDateTime endAt;

    public Training(Integer trainingId, Employee employeeCI, String name, String type, String description,
                    LocalDateTime startAt, LocalDateTime endAt) {
        this.trainingId = trainingId;
        this.employee = employeeCI;
        this.name = name;
        this.type = type;
        this.description = description;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Training() {
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }
}
