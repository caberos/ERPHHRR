package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.ContactDTO;

import java.util.List;

public interface ContactServices {
    List<ContactDTO> listContacts();
    ContactDTO getContact(Integer id);
    ContactDTO createContact(ContactDTO contact);
    ContactDTO updateContact(Integer id, ContactDTO contact);
    ContactDTO deleteContact(Integer id);
}
