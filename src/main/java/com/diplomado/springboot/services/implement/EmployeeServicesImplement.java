package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Employee;
import com.diplomado.springboot.dto.EmployeeDTO;
import com.diplomado.springboot.repositories.EmployeeRepository;
import com.diplomado.springboot.services.EmployeeServices;
import com.diplomado.springboot.services.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServicesImplement implements EmployeeServices {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServicesImplement(EmployeeMapper employeeMapper,
                                     EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> listEmployees() {
        return this.employeeRepository.findAll()
                .stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployee(Integer id) {
        List<Employee> employeeList = employeeRepository.findAll();
        Employee res = new Employee();
        for (Employee aux : employeeList) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
        }
        return this.employeeMapper.toDto(res);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        System.out.println(employee);
        return this.employeeMapper.toDto(
                employeeRepository.save(this.employeeMapper.toEntity(employee)));
    }

    @Override
    public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.getReferenceById(Long.valueOf(id));
        employeeRepository.save(employeeMapper.toUpdate(employee,employeeMapper.toEntity(employeeDTO)));
        return employeeDTO;
    }

    @Override
    public EmployeeDTO deleteEmployee(Integer id) {
        List<Employee> employeeList = employeeRepository.findAll();
        Employee res = new Employee();
        for (Employee aux : employeeList) {
            if (aux.getId() == id) {
                res = aux;
                employeeRepository.deleteById(Long.valueOf(id));
                break;
            }
        }
        return this.employeeMapper.toDto(res);
    }
}
