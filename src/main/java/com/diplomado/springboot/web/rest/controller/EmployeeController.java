package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.EmployeeDTO;
import com.diplomado.springboot.services.DepartmentServices;
import com.diplomado.springboot.services.EmployeeServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok().body(employeeServices.listEmployees());
    }

    @GetMapping(path = "/get/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Integer employeeId) {
        return employeeServices.getEmployee(employeeId);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {
        if (employeeDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(employeeServices.createEmployee(employeeDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<EmployeeDTO> updateDepartment(@PathVariable("id") Integer departmentId,
                                                          @RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(employeeServices.updateEmployee(departmentId, employeeDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<EmployeeDTO> deleteContact(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(employeeServices.deleteEmployee(id));
    }
}
