package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.LicensesCertificationsDTO;
import com.diplomado.springboot.services.LicensesCertificationsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/lic_cert")
@Tag(name = "Licencias o Certificados de Empleado")
public class LicensesCertificationsController {
    private final LicensesCertificationsServices licensesCertificationsServices;

    public LicensesCertificationsController(LicensesCertificationsServices licensesCertificationsServices) {
        this.licensesCertificationsServices = licensesCertificationsServices;
    }


    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de Licencias de todos los empleados")
    public ResponseEntity<List<LicensesCertificationsDTO>> getLicensesCertifications() {
        return ResponseEntity.ok().body(licensesCertificationsServices.listLicensesCertifications());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene la licencia de un empleado")
    public LicensesCertificationsDTO getLicensesCentificationById(@PathVariable("id") Integer LicensesCertificationId) {
        return licensesCertificationsServices.getLicensesCertification(LicensesCertificationId);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea una licencia para un empleado")
    public ResponseEntity<LicensesCertificationsDTO> createLicensesCertification(
            @Valid @RequestBody LicensesCertificationsDTO licensesCertificationsDTO) throws URISyntaxException {
        if (licensesCertificationsDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(licensesCertificationsServices
                .createLicensesCertification(licensesCertificationsDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza una licencia de un empleado")
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
    @Operation(summary = "Elimina una licencia de un empleado")
    public ResponseEntity<LicensesCertificationsDTO> deleteLicensesCertification(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(licensesCertificationsServices.deleteLicensesCertification(id));
    }
}
