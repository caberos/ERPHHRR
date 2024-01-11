package com.diplomado.springboot.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents")
public class Incidents {

    @Id
    @Column(name = "incident_id")
    private Integer incidentId;
    @Column(name = "employee_ci")
    private Integer employeeCI;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private Integer level;

    @Column(name = "incident_date")
    private LocalDateTime incidentDate;

    public Incidents(Integer incidentId, Integer employeeCI, String description, Integer level, LocalDateTime incidentDate) {
        this.incidentId = incidentId;
        this.employeeCI = employeeCI;
        this.description = description;
        this.level = level;
        this.incidentDate = incidentDate;
    }

    public Incidents() {
    }

    public Integer getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Integer incidentId) {
        this.incidentId = incidentId;
    }

    public Integer getEmployeeCI() {
        return employeeCI;
    }

    public void setEmployeeCI(Integer employeeCI) {
        this.employeeCI = employeeCI;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public LocalDateTime getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDateTime incidentDate) {
        this.incidentDate = incidentDate;
    }
}
