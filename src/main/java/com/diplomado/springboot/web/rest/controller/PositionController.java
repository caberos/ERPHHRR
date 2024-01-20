package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.PositionDTO;
import com.diplomado.springboot.services.PositionServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/position")
public class PositionController {
    private final PositionServices positionServices;

    public PositionController(PositionServices positionServices) {
        this.positionServices = positionServices;
    }


    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<PositionDTO>> getPositions() {
        return ResponseEntity.ok().body(positionServices.listPositions());
    }

    @GetMapping(path = "/get/{id}")
    public PositionDTO getPositionById(@PathVariable("id") Integer id) {
        return positionServices.getPosition(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PositionDTO> createPosition(@Valid @RequestBody PositionDTO positionDTO) throws URISyntaxException {
        if (positionDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(positionServices.createPosition(positionDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<PositionDTO> updatePosition(@PathVariable("id") Integer id,
                                                          @RequestBody PositionDTO positionDTO) {
        if (positionDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(positionServices.updatePosition(id, positionDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<PositionDTO> deletePosition(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(positionServices.deletePosition(id));
    }
}
