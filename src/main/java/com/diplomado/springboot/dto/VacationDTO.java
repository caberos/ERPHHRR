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
public class VacationDTO {
    private Integer vacationId;

    private Employee employee;
    private String reason;
    private LocalDateTime duration;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
