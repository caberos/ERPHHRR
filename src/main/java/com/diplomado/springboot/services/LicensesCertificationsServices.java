package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.LicensesCertificationsDTO;

import java.util.List;

public interface LicensesCertificationsServices {
    List<LicensesCertificationsDTO> listLicensesCertifications();
    LicensesCertificationsDTO getLicensesCertification(Integer id);
    LicensesCertificationsDTO createLicensesCertification(LicensesCertificationsDTO licensesCertification);
    LicensesCertificationsDTO updateLicensesCertification(Integer id, LicensesCertificationsDTO licensesCertification);
    LicensesCertificationsDTO deleteLicensesCertification(Integer id);
}
