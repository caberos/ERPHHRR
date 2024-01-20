package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.ContactDTO;
import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.services.DepartmentServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/department")
public class DepartmentController {

    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices de) {
        this.departmentServices = de;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        return ResponseEntity.ok().body(departmentServices.listDepartment());
    }

    @GetMapping(path = "/get/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable("id") Integer departmentId) {
        return departmentServices.getDepartment(departmentId);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {
        if (departmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(departmentServices.createDepartment(departmentDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Integer departmentId,
                                                    @RequestBody DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(departmentServices.updateDepartment(departmentId, departmentDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<DepartmentDTO> deleteContact(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(departmentServices.deleteDepartment(id));
    }
}
