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
public class IncidentsDTO {
    private Integer incidentId;

    private Employee employee;

    private String description;

    private Integer level;

    private LocalDateTime incidentDate;
}
