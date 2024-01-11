package com.diplomado.springboot.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ci")
    private Integer ci;

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

    public Employee(Integer ci, Integer supervisorId, String name, String role,
                    String phone, String password, String city, Timestamp birthday, Timestamp startAt) {
        this.ci = ci;
        this.supervisorId = supervisorId;
        this.name = name;
        this.role = role;
        this.phone = phone;
        this.password = password;
        this.city = city;
        this.birthday = birthday;
        this.startAt = startAt;
    }

    public Employee() {
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
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
}

