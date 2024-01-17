package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Contact;
import com.diplomado.springboot.dto.ContactDTO;

public class ContactMapper implements CustomMapper<ContactDTO, Contact>{
    @Override
    public ContactDTO toDto(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setContactId(contact.getContactId());
        contactDTO.setName(contact.getName());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setAddress(contact.getAddress());
        contactDTO.setRelation(contact.getRelation());
        contactDTO.setEmployee(contact.getEmployee());
        return contactDTO;
    }

    @Override
    public Contact toEntity(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setContactId(contactDTO.getContactId());
        contact.setName(contactDTO.getName());
        contact.setAddress(contactDTO.getAddress());
        contact.setPhone(contactDTO.getPhone());
        contact.setRelation(contactDTO.getRelation());
        contact.setEmployee(contactDTO.getEmployee());
        return contact;
    }
}
