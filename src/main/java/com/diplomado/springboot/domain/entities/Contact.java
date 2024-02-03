package com.diplomado.springboot.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer contactId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @Column(name = "name")
    private String name;
    @Column(name = "relation")
    private String relation;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    public Contact(Integer contactId, Employee employee, String name, String relation,
                   String phone, String address) {
        this.contactId = contactId;
        this.employee = employee;
        this.name = name;
        this.relation = relation;
        this.phone = phone;
        this.address = address;
    }

    public Contact() {
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
