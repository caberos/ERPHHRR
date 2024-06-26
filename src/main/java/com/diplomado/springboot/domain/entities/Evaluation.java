package com.diplomado.springboot.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Integer evaluationId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @Column(name = "year")
    private Integer year;
    @Column(name = "time_scale")
    private Date timeScale;
    @Column(name = "comments")
    private String comments;
    @Column(name = "score")
    private Integer score;
    @Column(name = "eval_time")
    private Date evalTime;

    public Evaluation(Integer evaluationId, Employee employee, Integer year, Date timeScale,
                      String comments, Integer score, Date evalTime) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(Date timeScale) {
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

    public Date getEvalTime() {
        return evalTime;
    }

    public void setEvalTime(Date evalTime) {
        this.evalTime = evalTime;
    }
}
