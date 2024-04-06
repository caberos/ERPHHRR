package com.diplomado.springboot.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "accomplishments")
public class Accomplishments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accomplishment_id")
    private Integer accomplishmentId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @Column(name = "description")
    private String description;

    @Column(name = "accomplishment_date")
    private Date accomplishmentDate;

    public Accomplishments(Integer accomplishmentId, Employee employee,
                           String description, Date accomplishmentDate) {
        this.accomplishmentId = accomplishmentId;
        this.employee = employee;
        this.description = description;
        this.accomplishmentDate = accomplishmentDate;
    }

    public Accomplishments() {
    }

    public Integer getAccomplishmentId() {
        return accomplishmentId;
    }

    public void setAccomplishmentId(Integer accomplishmentId) {
        this.accomplishmentId = accomplishmentId;
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

    public Date getAccomplishmentDate() {
        return accomplishmentDate;
    }

    public void setAccomplishmentDate(Date accomplishmentDate) {
        this.accomplishmentDate = accomplishmentDate;
    }
}
