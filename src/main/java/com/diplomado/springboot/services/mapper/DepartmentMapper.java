package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Department;
import com.diplomado.springboot.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper implements CustomMapper<DepartmentDTO, Department> {
    @Override
    public DepartmentDTO toDto(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setDescription(department.getDescription());
        departmentDTO.setPositions(department.getPositions());
        return departmentDTO;
    }

    @Override
    public Department toEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        department.setPositions(departmentDTO.getPositions());
        return department;
    }
}
