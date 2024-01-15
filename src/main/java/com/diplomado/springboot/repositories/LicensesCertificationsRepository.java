package com.diplomado.springboot.repositories;

import com.diplomado.springboot.domain.entities.LicensesCertifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicensesCertificationsRepository extends JpaRepository<LicensesCertifications, Integer> {
}
