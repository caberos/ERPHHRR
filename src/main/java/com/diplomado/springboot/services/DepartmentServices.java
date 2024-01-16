package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentServices {

    List<DepartmentDTO> listDepartment();
    DepartmentDTO getDepartment(Integer id);
    DepartmentDTO createDepartment(DepartmentDTO department);
    DepartmentDTO updateDepartment(Integer id, DepartmentDTO department);
    DepartmentDTO deleteDepartment(Integer id);
}
