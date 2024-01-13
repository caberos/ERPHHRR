package com.diplomado.springboot.domain.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer contactId;

    @ManyToOne
    @JoinColumn(name = "employee_ci")
    private Employee employee;
    @Column(name = "name")
    private String name;
    @Column(name = "relation")
    private Integer relation;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "address")
    private Integer address;

    public Contact(Integer contactId, Employee employee, String name, Integer relation,
                   Integer phone, Integer address) {
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

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }
}
