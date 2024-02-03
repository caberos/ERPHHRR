package com.diplomado.springboot.domain.entities;

import com.diplomado.springboot.dto.AccomplishmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "supervisor_id")
    private Integer supervisorId;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "birthday")
    private Timestamp birthday;

    @Column(name = "start_at")
    private Timestamp startAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Position> positions;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LaborHistory> laborHistories;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Training> trainings;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LicensesCertifications> licensesCertifications;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Incidents> incidents;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contact> contacts;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Accomplishments> accomplishments;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vacations> vacations;

    public Employee(Integer id, Integer supervisorId, String name, String role, String phone,
                    String password, String city, Timestamp birthday, Timestamp startAt,
                    List<Position> positions, List<LaborHistory> laborHistories, List<Training> trainings,
                    List<LicensesCertifications> licensesCertifications, List<Evaluation> evaluations,
                    List<Incidents> incidents,
                    List<Contact> contacts, List<Accomplishments> accomplishments, List<Vacations> vacations) {
        this.id = id;
        this.supervisorId = supervisorId;
        this.name = name;
        this.role = role;
        this.phone = phone;
        this.password = password;
        this.city = city;
        this.birthday = birthday;
        this.startAt = startAt;
        this.positions = positions;
        this.laborHistories = laborHistories;
        this.trainings = trainings;
        this.licensesCertifications = licensesCertifications;
        this.evaluations = evaluations;
        this.incidents = incidents;
        this.contacts = contacts;
        this.accomplishments = accomplishments;
        this.vacations = vacations;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<LaborHistory> getLaborHistories() {
        return laborHistories;
    }

    public void setLaborHistories(List<LaborHistory> laborHistories) {
        this.laborHistories = laborHistories;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<LicensesCertifications> getLicensesCertifications() {
        return licensesCertifications;
    }

    public void setLicensesCertifications(List<LicensesCertifications> licensesCertifications) {
        this.licensesCertifications = licensesCertifications;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Incidents> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incidents> incidents) {
        this.incidents = incidents;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Accomplishments> getAccomplishments() {
        return accomplishments;
    }

    public void setAccomplishments(List<Accomplishments> accomplishments) {
        this.accomplishments = accomplishments;
    }

    public List<Vacations> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacations> vacations) {
        this.vacations = vacations;
    }
}

