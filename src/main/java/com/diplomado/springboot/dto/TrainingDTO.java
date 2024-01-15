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
public class TrainingDTO {
    private Integer trainingId;
    private Employee employee;
    private String name;
    private String type;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
