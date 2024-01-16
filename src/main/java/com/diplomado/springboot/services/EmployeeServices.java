package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeServices {

    List<EmployeeDTO> listEmployees();
    EmployeeDTO getEmployee(Integer id);
    EmployeeDTO createEmployee(EmployeeDTO employee);
    EmployeeDTO updateEmployee(Integer id, EmployeeDTO employee);
    EmployeeDTO deleteEmployee(Integer id);

}
