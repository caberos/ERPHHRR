package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.EmployeeDTO;
import com.diplomado.springboot.dto.PositionDTO;
import com.diplomado.springboot.services.EmployeeServices;
import com.diplomado.springboot.services.PositionServices;
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
    private final PositionServices positionServices;

    public EmployeeController(EmployeeServices employeeServices, PositionServices positionServices) {
        this.employeeServices = employeeServices;
        this.positionServices = positionServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok().body(employeeServices.listEmployees());
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Integer employeeId) {
        return ResponseEntity.ok().body(employeeServices.getEmployee(employeeId));
    }
    @GetMapping(path = "/getAllPositions/{id}")
    public ResponseEntity<List<PositionDTO>> getAllPositionsByEmployeeId(@PathVariable("id") Integer employeeId) {
        return ResponseEntity.ok().body(positionServices.getPositionByEmployeeId(employeeId));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {
        System.out.println(employeeDTO);
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
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(employeeServices.deleteEmployee(id));
    }
}
