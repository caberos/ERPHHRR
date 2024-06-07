package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.AccomplishmentDTO;
import com.diplomado.springboot.services.AccomplishmentsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/accomplishment")
@Tag(name = "Logros de Empleado")
public class AccomplishmentController {

    private final AccomplishmentsServices accomplishmentsServices;

    public AccomplishmentController(AccomplishmentsServices accomplishmentsServices) {
        this.accomplishmentsServices = accomplishmentsServices;
    }

    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de logros de todos los empleados")
    public ResponseEntity<List<AccomplishmentDTO>> getAllAccomplishment() {
        return ResponseEntity.ok().body(accomplishmentsServices.listAccomplishment());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene el detalle de un logro enviando el id del logro.")
    public AccomplishmentDTO getAccomplishment(@PathVariable("id") Integer id) {
        return accomplishmentsServices.getAccomplishment(id);
    }

    @GetMapping(path = "/getAllByEmployeeId/{id}")
    @Operation(summary = "Obtiene la lista de logros de un empleado especifico mandando el CI")
    public List<AccomplishmentDTO>  getAccomplishmentByEmpId(@PathVariable("id") Integer employeeId) {
        return accomplishmentsServices.listAccomplishmentByEmployeeID(employeeId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea un logro")
    public ResponseEntity<AccomplishmentDTO> createAccomplishment(@Valid @RequestBody AccomplishmentDTO accomplishmentDTO) throws URISyntaxException {
        if (accomplishmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(accomplishmentsServices.createAccomplishment(accomplishmentDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza un logro")
    public ResponseEntity<AccomplishmentDTO> updateAccomplishment(@PathVariable("id") Integer rolId,
                                                       @RequestBody AccomplishmentDTO accomplishmentDTO) {
        if (accomplishmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(accomplishmentsServices.updateAccomplishment(rolId, accomplishmentDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina un logro enviando un id")
    public ResponseEntity<AccomplishmentDTO> deleteAccomplishment(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(accomplishmentsServices.deleteAccomplishment(id));
    }


}
