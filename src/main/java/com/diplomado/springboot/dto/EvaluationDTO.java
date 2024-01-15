package com.diplomado.springboot.dto;

import com.diplomado.springboot.domain.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {
    private Integer evaluationId;

    private Employee employee;
    private LocalDateTime year;
    private LocalDateTime timeScale;
    private String comments;
    private Integer score;
    private LocalDateTime evalTime;

}
