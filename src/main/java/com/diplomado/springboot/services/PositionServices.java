package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.PositionDTO;

import java.util.List;

public interface PositionServices {
    List<PositionDTO> listPositions();

    PositionDTO getPosition(Integer id);

    PositionDTO createPosition(PositionDTO position);

    PositionDTO updatePosition(Integer id, PositionDTO position);

    PositionDTO deletePosition(Integer id);
}
