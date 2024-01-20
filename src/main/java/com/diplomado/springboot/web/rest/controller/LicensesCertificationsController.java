package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.LicensesCertificationsDTO;
import com.diplomado.springboot.services.LicensesCertificationsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/lic_cert")
public class LicensesCertificationsController {
    private final LicensesCertificationsServices licensesCertificationsServices;

    public LicensesCertificationsController(LicensesCertificationsServices licensesCertificationsServices) {
        this.licensesCertificationsServices = licensesCertificationsServices;
    }


    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<LicensesCertificationsDTO>> getLicensesCertifications() {
        return ResponseEntity.ok().body(licensesCertificationsServices.listLicensesCertifications());
    }

    @GetMapping(path = "/get/{id}")
    public LicensesCertificationsDTO getLicensesCentificationById(@PathVariable("id") Integer LicensesCertificationId) {
        return licensesCertificationsServices.getLicensesCertification(LicensesCertificationId);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<LicensesCertificationsDTO> createLicensesCertification(
            @Valid @RequestBody LicensesCertificationsDTO licensesCertificationsDTO) throws URISyntaxException {
        if (licensesCertificationsDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(licensesCertificationsServices
                .createLicensesCertification(licensesCertificationsDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<LicensesCertificationsDTO>
    updateLicensesCertification(@PathVariable("id") Integer id,
                                @RequestBody LicensesCertificationsDTO licensesCertificationsDTO) {
        if (licensesCertificationsDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(licensesCertificationsServices.updateLicensesCertification(id,
                licensesCertificationsDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<LicensesCertificationsDTO> deleteLicensesCertification(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(licensesCertificationsServices.deleteLicensesCertification(id));
    }
}
