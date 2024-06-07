package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.ContactDTO;
import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.services.DepartmentServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/department")
@Tag(name = "Departamentos de la empresa")
public class DepartmentController {

    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices de) {
        this.departmentServices = de;
    }

    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de los departamentos de la empresa")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        return ResponseEntity.ok().body(departmentServices.listDepartment());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene el departamento de la empresa segun el Identificador")
    public DepartmentDTO getDepartmentById(@PathVariable("id") Integer departmentId) {
        return departmentServices.getDepartment(departmentId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea un departamento en la empresa")
    public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {
        if (departmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(departmentServices.createDepartment(departmentDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza el departamento de una empresa")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Integer departmentId,
                                                    @RequestBody DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(departmentServices.updateDepartment(departmentId, departmentDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina el departamento")
    public ResponseEntity<DepartmentDTO> deleteContact(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(departmentServices.deleteDepartment(id));
    }
}
