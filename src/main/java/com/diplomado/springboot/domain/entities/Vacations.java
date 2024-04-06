package com.diplomado.springboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "vacation")
public class Vacations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Integer vacationId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @Column(name = "reason")
    private String reason;
    @Column(name = "duration")
    private Date duration;
    @Column(name = "start_at")
    private Date startAt;
    @Column(name = "end_at")
    private Date endAt;

    public Vacations(Integer vacationId, Employee employee, String reason, Date duration,
                     Date startAt, Date endAt) {
        this.vacationId = vacationId;
        this.employee = employee;
        this.reason = reason;
        this.duration = duration;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Vacations() {
    }

    public Integer getVacationId() {
        return vacationId;
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId = vacationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }
}
