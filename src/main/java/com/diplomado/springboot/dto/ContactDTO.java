package com.diplomado.springboot.dto;


import com.diplomado.springboot.domain.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private Integer contactId;

    private Employee employee;
    private String name;
    private Integer relation;
    private Integer phone;
    private Integer address;
}
