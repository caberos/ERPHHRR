package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.LicensesCertifications;
import com.diplomado.springboot.dto.LicensesCertificationsDTO;

public class LicensesCertificationsMapper implements CustomMapper<LicensesCertificationsDTO, LicensesCertifications>{
    @Override
    public LicensesCertificationsDTO toDto(LicensesCertifications licensesCertifications) {
        LicensesCertificationsDTO licensesCertificationsDTO =new LicensesCertificationsDTO();
        licensesCertificationsDTO.setLicensesId(licensesCertifications.getLicensesId());
        licensesCertificationsDTO.setEmployee(licensesCertifications.getEmployee());
        licensesCertificationsDTO.setExpired(licensesCertifications.getExpired());
        licensesCertificationsDTO.setName(licensesCertifications.getName());
        return licensesCertificationsDTO;
    }

    @Override
    public LicensesCertifications toEntity(LicensesCertificationsDTO licensesCertificationsDTO) {
        LicensesCertifications licensesCertifications =new LicensesCertifications();
        licensesCertifications.setLicensesId(licensesCertificationsDTO.getLicensesId());
        licensesCertifications.setEmployee(licensesCertificationsDTO.getEmployee());
        licensesCertifications.setExpired(licensesCertificationsDTO.getExpired());
        licensesCertifications.setName(licensesCertificationsDTO.getName());
        return licensesCertifications;
    }
}
