package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.AccomplishmentDTO;
import com.diplomado.springboot.dto.ContactDTO;
import com.diplomado.springboot.services.AccomplishmentsServices;
import com.diplomado.springboot.services.ContactServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/contact")
@Tag(name = "Contactos de Empleado")
public class ContactController {
    private final ContactServices contactServices;

    public ContactController(ContactServices contactServices) {
        this.contactServices = contactServices;
    }

    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de contactos de todos los empleados")
    public ResponseEntity<List<ContactDTO>> getContacts() {
        return ResponseEntity.ok().body(contactServices.listContacts());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene la lista de contactos de un empleado")
    public ContactDTO getContactById(@PathVariable("id") Integer contactId) {
        return contactServices.getContact(contactId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea un contacto de un empleado")
    public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO contactDTO) throws URISyntaxException {
        if (contactDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(contactServices.createContact(contactDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza un contacto de un empleado")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable("id") Integer contactId,
                                                                  @RequestBody ContactDTO contactDTO) {
        if (contactDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(contactServices.updateContact(contactId, contactDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina el contacto de un empleado")
    public ResponseEntity<ContactDTO> deleteContact(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(contactServices.deleteContact(id));
    }

}
