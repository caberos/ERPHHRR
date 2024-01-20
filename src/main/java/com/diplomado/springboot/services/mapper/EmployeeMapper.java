package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Employee;
import com.diplomado.springboot.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements CustomMapper<EmployeeDTO, Employee>{
    @Override
    public EmployeeDTO toDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCi(employee.getCi());
        employeeDTO.setName(employee.getName());
        employeeDTO.setCity(employee.getCity());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setContacts(employee.getContacts());
        employeeDTO.setAccomplishments(employee.getAccomplishments());
        employeeDTO.setBirthday(employee.getBirthday());
        employeeDTO.setIncidents(employee.getIncidents());
        employeeDTO.setLaborHistories(employee.getLaborHistories());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setEvaluations(employee.getEvaluations());
        employeeDTO.setStartAt(employee.getStartAt());
        employeeDTO.setSupervisorId(employee.getSupervisorId());
        employeeDTO.setTrainings(employee.getTrainings());
        employeeDTO.setVacations(employee.getVacations());
        employeeDTO.setPositions(employee.getPositions());
        employeeDTO.setLicensesCertifications(employee.getLicensesCertifications());
        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setCi(employeeDTO.getCi());
        employee.setName(employeeDTO.getName());
        employee.setCity(employeeDTO.getCity());
        employee.setPassword(employeeDTO.getPassword());
        employee.setContacts(employeeDTO.getContacts());
        employee.setAccomplishments(employeeDTO.getAccomplishments());
        employee.setBirthday(employeeDTO.getBirthday());
        employee.setIncidents(employeeDTO.getIncidents());
        employee.setLaborHistories(employeeDTO.getLaborHistories());
        employee.setRole(employeeDTO.getRole());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEvaluations(employeeDTO.getEvaluations());
        employee.setStartAt(employeeDTO.getStartAt());
        employee.setSupervisorId(employeeDTO.getSupervisorId());
        employee.setTrainings(employeeDTO.getTrainings());
        employee.setVacations(employeeDTO.getVacations());
        employee.setPositions(employeeDTO.getPositions());
        employee.setLicensesCertifications(employeeDTO.getLicensesCertifications());
        return employee;
    }

    public Employee toUpdate(Employee employee,Employee employeeDTO) {
        employee.setCi(employeeDTO.getCi());
        employee.setName(employeeDTO.getName());
        employee.setCity(employeeDTO.getCity());
        employee.setPassword(employeeDTO.getPassword());
        employee.setContacts(employeeDTO.getContacts());
        employee.setAccomplishments(employeeDTO.getAccomplishments());
        employee.setBirthday(employeeDTO.getBirthday());
        employee.setIncidents(employeeDTO.getIncidents());
        employee.setLaborHistories(employeeDTO.getLaborHistories());
        employee.setRole(employeeDTO.getRole());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEvaluations(employeeDTO.getEvaluations());
        employee.setStartAt(employeeDTO.getStartAt());
        employee.setSupervisorId(employeeDTO.getSupervisorId());
        employee.setTrainings(employeeDTO.getTrainings());
        employee.setVacations(employeeDTO.getVacations());
        employee.setPositions(employeeDTO.getPositions());
        employee.setLicensesCertifications(employeeDTO.getLicensesCertifications());
        return employee;
    }
}
