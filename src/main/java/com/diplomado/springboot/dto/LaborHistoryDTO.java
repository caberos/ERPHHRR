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
public class LaborHistoryDTO {
    private Integer historyId;

    private Employee employee;
    private Integer postId;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
