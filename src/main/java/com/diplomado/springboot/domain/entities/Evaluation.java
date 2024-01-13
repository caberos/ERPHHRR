package com.diplomado.springboot.domain.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Integer evaluationId;

    @ManyToOne
    @JoinColumn(name = "employee_ci")
    private Employee employee;
    @Column(name = "year")
    private LocalDateTime year;
    @Column(name = "time_scale")
    private LocalDateTime timeScale;
    @Column(name = "comments")
    private String comments;
    @Column(name = "score")
    private Integer score;
    @Column(name = "eval_time")
    private LocalDateTime evalTime;

    public Evaluation(Integer evaluationId, Employee employee, LocalDateTime year, LocalDateTime timeScale,
                      String comments, Integer score, LocalDateTime evalTime) {
        this.evaluationId = evaluationId;
        this.employee = employee;
        this.year = year;
        this.timeScale = timeScale;
        this.comments = comments;
        this.score = score;
        this.evalTime = evalTime;
    }

    public Evaluation() {
    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public LocalDateTime getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(LocalDateTime timeScale) {
        this.timeScale = timeScale;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getEvalTime() {
        return evalTime;
    }

    public void setEvalTime(LocalDateTime evalTime) {
        this.evalTime = evalTime;
    }
}
