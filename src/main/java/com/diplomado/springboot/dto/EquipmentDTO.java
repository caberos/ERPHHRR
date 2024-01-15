package com.diplomado.springboot.dto;

import com.diplomado.springboot.domain.entities.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private String brand;
    private List<Position> positions;
}
