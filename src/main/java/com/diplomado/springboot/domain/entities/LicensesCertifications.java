package com.diplomado.springboot.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Licenses_Certifications")
public class LicensesCertifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "licenses_id")
    private Integer licensesId;

    @ManyToOne
    @JoinColumn(name = "employee_ci")
    private Employee employee;

    @Column(name = "name")
    private String name;

    @Column(name = "expired")
    private LocalDateTime expired;

    public LicensesCertifications(Integer licensesId, Employee employee, String name, LocalDateTime expired) {
        this.licensesId = licensesId;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
