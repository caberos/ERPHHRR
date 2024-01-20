package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
