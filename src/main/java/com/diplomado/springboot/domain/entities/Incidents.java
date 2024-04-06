package com.diplomado.springboot.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "incidents")
public class Incidents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private Integer incidentId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private Integer level;

    @Column(name = "incident_date")
    private Date incidentDate;

    public Incidents(Integer incidentId, Employee employee, String description,
                     Integer level, Date incidentDate) {
        this.incidentId = incidentId;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }
}
