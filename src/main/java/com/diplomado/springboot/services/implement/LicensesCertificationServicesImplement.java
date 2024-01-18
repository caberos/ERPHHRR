package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Evaluation;
import com.diplomado.springboot.domain.entities.LicensesCertifications;
import com.diplomado.springboot.dto.LicensesCertificationsDTO;
import com.diplomado.springboot.repositories.LicensesCertificationsRepository;
import com.diplomado.springboot.services.LicensesCertificationsServices;
import com.diplomado.springboot.services.mapper.LicensesCertificationsMapper;

import java.util.List;
import java.util.stream.Collectors;

public class LicensesCertificationServicesImplement implements LicensesCertificationsServices {

    private final LicensesCertificationsMapper licensesCertificationsMapper;
    private final LicensesCertificationsRepository licensesCertificationsRepository;

    public LicensesCertificationServicesImplement(LicensesCertificationsMapper licensesCertificationsMapper,
                                                  LicensesCertificationsRepository licensesCertificationsRepository) {
        this.licensesCertificationsMapper = licensesCertificationsMapper;
        this.licensesCertificationsRepository = licensesCertificationsRepository;
    }

    @Override
    public List<LicensesCertificationsDTO> listLicensesCertifications() {
        return this.licensesCertificationsRepository.findAll()
                .stream().map(licensesCertificationsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LicensesCertificationsDTO getLicensesCertification(Integer id) {
        List<LicensesCertifications> licensesCertifications = licensesCertificationsRepository.findAll();
        LicensesCertifications res = new LicensesCertifications();
        for (LicensesCertifications aux : licensesCertifications) {
            if (aux.getLicensesId() == id) {
                res = aux;
                break;
            }
        }
        return this.licensesCertificationsMapper.toDto(res);
    }

    @Override
    public LicensesCertificationsDTO createLicensesCertification(LicensesCertificationsDTO licensesCertification) {
        return this.licensesCertificationsMapper.toDto(
                licensesCertificationsRepository.save(this.licensesCertificationsMapper
                        .toEntity(licensesCertification)));
    }

    @Override
    public LicensesCertificationsDTO updateLicensesCertification(Integer id,
                                                                 LicensesCertificationsDTO licensesCertificationsDTO) {
        LicensesCertifications licensesCertifications = licensesCertificationsRepository.getReferenceById(id);
        licensesCertifications.setLicensesId(licensesCertificationsDTO.getLicensesId());
        licensesCertifications.setEmployee(licensesCertificationsDTO.getEmployee());
        licensesCertifications.setExpired(licensesCertificationsDTO.getExpired());
        licensesCertifications.setName(licensesCertificationsDTO.getName());
        licensesCertificationsRepository.save(licensesCertifications);
        return this.licensesCertificationsMapper.toDto(licensesCertifications);
    }

    @Override
    public LicensesCertificationsDTO deleteLicensesCertification(Integer id) {
        List<LicensesCertifications> licensesCertifications = licensesCertificationsRepository.findAll();
        LicensesCertifications res = new LicensesCertifications();
        for (LicensesCertifications aux : licensesCertifications) {
            if (aux.getLicensesId() == id) {
                res = aux;
                licensesCertificationsRepository.deleteById(id);
                break;
            }
        }
        return this.licensesCertificationsMapper.toDto(res);
    }
}
