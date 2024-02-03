package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.AccomplishmentDTO;
import com.diplomado.springboot.services.AccomplishmentsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/accomplishment")
public class AccomplishmentController {

    private final AccomplishmentsServices accomplishmentsServices;

    public AccomplishmentController(AccomplishmentsServices accomplishmentsServices) {
        this.accomplishmentsServices = accomplishmentsServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<AccomplishmentDTO>> getAllAccomplishment() {
        return ResponseEntity.ok().body(accomplishmentsServices.listAccomplishment());
    }

    @GetMapping(path = "/get/{id}")
    public AccomplishmentDTO getAccomplishment(@PathVariable("id") Integer id) {
        return accomplishmentsServices.getAccomplishment(id);
    }

    @GetMapping(path = "/getAllByEmployeeId/{id}")
    public List<AccomplishmentDTO>  getAccomplishmentByEmpId(@PathVariable("id") Integer employeeId) {
        return accomplishmentsServices.listAccomplishmentByEmployeeID(employeeId);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<AccomplishmentDTO> createAccomplishment(@Valid @RequestBody AccomplishmentDTO rolDTO) throws URISyntaxException {
        if (rolDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(accomplishmentsServices.createAccomplishment(rolDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<AccomplishmentDTO> updateAccomplishment(@PathVariable("id") Integer rolId,
                                                       @RequestBody AccomplishmentDTO accomplishmentDTO) {
        if (accomplishmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(accomplishmentsServices.updateAccomplishment(rolId, accomplishmentDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<AccomplishmentDTO> deleteAccomplishment(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(accomplishmentsServices.deleteAccomplishment(id));
    }


}
