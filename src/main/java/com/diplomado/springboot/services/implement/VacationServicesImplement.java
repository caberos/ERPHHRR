package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.dto.VacationDTO;
import com.diplomado.springboot.repositories.VacationsRepository;
import com.diplomado.springboot.services.VacationsServices;
import com.diplomado.springboot.services.mapper.VacationsMapper;

import java.util.List;
import java.util.stream.Collectors;

public class VacationServicesImplement implements VacationsServices {

    private final VacationsRepository vacationsRepository;
    private final VacationsMapper vacationsMapper;

    public VacationServicesImplement(VacationsRepository vacationsRepository, VacationsMapper vacationsMapper) {
        this.vacationsRepository = vacationsRepository;
        this.vacationsMapper = vacationsMapper;
    }

    @Override
    public List<VacationDTO> listVacations() {
//        return vacationsRepository.findAll()
//                .stream().map(vacationsMapper::toDTO).collect(Collectors.toList());
        return null;
    }

    @Override
    public VacationDTO getVacations(Integer id) {
        return null;
    }

    @Override
    public VacationDTO createVacations(VacationDTO vacation) {
        return null;
    }

    @Override
    public VacationDTO updateVacations(Integer id, VacationDTO vacation) {
        return null;
    }

    @Override
    public VacationDTO deleteVacations(Integer id) {
        return null;
    }
}
