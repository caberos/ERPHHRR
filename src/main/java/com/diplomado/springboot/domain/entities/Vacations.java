package com.diplomado.springboot.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vacation")
public class Vacations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Integer vacationId;

    @ManyToOne
    @JoinColumn(name = "employee_ci")
    private Employee employee;
    @Column(name = "reason")
    private String reason;
    @Column(name = "duration")
    private LocalDateTime duration;
    @Column(name = "start_at")
    private LocalDateTime startAt;
    @Column(name = "end_at")
    private LocalDateTime endAt;

    public Vacations(Integer vacationId, Employee employee, String reason, LocalDateTime duration,
                     LocalDateTime startAt, LocalDateTime endAt) {
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

    public LocalDateTime getDuration() {
        return duration;
    }

    public void setDuration(LocalDateTime duration) {
        this.duration = duration;
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
