package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Contact;
import com.diplomado.springboot.domain.entities.Vacations;
import com.diplomado.springboot.dto.ContactDTO;
import com.diplomado.springboot.repositories.ContactRepository;
import com.diplomado.springboot.services.ContactServices;
import com.diplomado.springboot.services.mapper.ContactMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServicesImplement implements ContactServices {

    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    public ContactServicesImplement(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactDTO> listContacts() {
        return contactRepository.findAll()
                .stream().map(contactMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ContactDTO getContact(Integer id) {
        List<Contact> contactList = contactRepository.findAll();
        Contact res = new Contact();
        for (Contact aux : contactList) {
            if (aux.getContactId() == id) {
                res = aux;
                break;
            }
        }
        return this.contactMapper.toDto(res);
    }

    @Override
    public ContactDTO createContact(ContactDTO contact) {
        return this.contactMapper.toDto(
                contactRepository.save(this.contactMapper.toEntity(contact)));
    }

    @Override
    public ContactDTO updateContact(Integer id, ContactDTO contactDTO) {
        Contact contact = contactRepository.getReferenceById(Long.valueOf(id));
        contact.setContactId(contactDTO.getContactId());
        contact.setName(contactDTO.getName());
        contact.setAddress(contactDTO.getAddress());
        contact.setPhone(contactDTO.getPhone());
        contact.setRelation(contactDTO.getRelation());
        contact.setEmployee(contactDTO.getEmployee());
        contactRepository.save(contact);
        return this.contactMapper.toDto(contact);
    }

    @Override
    public ContactDTO deleteContact(Integer id) {
        List<Contact> contactList = contactRepository.findAll();
        Contact res = new Contact();
        for (Contact aux : contactList) {
            if (aux.getContactId() == id) {
                res = aux;
                contactRepository.deleteById(Long.valueOf(id));
                break;
            }
        }
        return this.contactMapper.toDto(res);
    }
}
