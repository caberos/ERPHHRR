package com.diplomado.springboot.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "Licenses_Certifications")
public class LicensesCertifications {

    @Id
    @Column(name = "licenses_id")
    private Integer licensesId;

    @Column(name = "employee_ci")
    private Integer employeeCI;

    @Column(name = "name")
    private String name;

    @Column(name = "expired")
    private LocalDateTime expired;

    public LicensesCertifications(Integer licensesId, Integer employeeCI, String name, LocalDateTime expired) {
        this.licensesId = licensesId;
        this.employeeCI = employeeCI;
        this.name = name;
        this.expired = expired;
    }

    public LicensesCertifications() {
    }

    public Integer getLicensesId() {
        return licensesId;
    }

    public void setLicensesId(Integer licensesId) {
        this.licensesId = licensesId;
    }

    public Integer getEmployeeCI() {
        return employeeCI;
    }

    public void setEmployeeCI(Integer employeeCI) {
        this.employeeCI = employeeCI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpired() {
        return expired;
    }

    public void setExpired(LocalDateTime expired) {
        this.expired = expired;
    }
}
