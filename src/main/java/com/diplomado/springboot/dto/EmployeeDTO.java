package com.diplomado.springboot.dto;

import com.diplomado.springboot.domain.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Integer id;

    private Integer supervisorId;

    private String name;

    private String role;

    private String phone;

    private String password;

    private String city;

    private Timestamp birthday;

    private Timestamp startAt;

    private List<Position> positions;

    private List<LaborHistory> laborHistories;

    private List<Training> trainings;

    private List<LicensesCertifications> licensesCertifications;

    private List<Evaluation> evaluations;

    private List<Incidents> incidents;

    private List<Contact> contacts;

    @OneToMany(mappedBy = "employee")
    private List<Accomplishments> accomplishments;

    private List<Vacations> vacations;
}
