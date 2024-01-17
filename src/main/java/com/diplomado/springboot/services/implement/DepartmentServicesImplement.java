package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Contact;
import com.diplomado.springboot.domain.entities.Department;
import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.repositories.DepartmentRepository;
import com.diplomado.springboot.services.DepartmentServices;
import com.diplomado.springboot.services.mapper.DepartmentMapper;

import java.util.List;

public class DepartmentServicesImplement implements DepartmentServices {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentServicesImplement(DepartmentMapper departmentMapper,
                                       DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTO> listDepartment() {
        return this.departmentRepository.findAll()
                .stream().map(departmentMapper::toDto).toList();
    }

    @Override
    public DepartmentDTO getDepartment(Integer id) {
        List<Department> departmentList = departmentRepository.findAll();
        Department res = new Department();
        for (Department aux : departmentList) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
        }
        return this.departmentMapper.toDto(res);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO department) {
        return this.departmentMapper.toDto(
                departmentRepository.save(this.departmentMapper.toEntity(department)));
    }

    @Override
    public DepartmentDTO updateDepartment(Integer id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.getReferenceById(id);
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        department.setPositions(departmentDTO.getPositions());
        departmentRepository.save(department);
        return this.departmentMapper.toDto(department);
    }

    @Override
    public DepartmentDTO deleteDepartment(Integer id) {
        List<Department> departmentList = departmentRepository.findAll();
        Department res = new Department();
        for (Department aux : departmentList) {
            if (aux.getId() == id) {
                res = aux;
                departmentRepository.deleteById(id);
                break;
            }
        }
        return this.departmentMapper.toDto(res);
    }
}
