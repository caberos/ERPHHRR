package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.ContactDTO;

import java.util.List;

public interface ContactServices {
    List<ContactDTO> listContacts();
}
