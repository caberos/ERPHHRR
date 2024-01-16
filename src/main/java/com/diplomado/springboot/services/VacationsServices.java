package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.VacationDTO;

import java.util.List;

public interface VacationsServices {
    List<VacationDTO> listVacations();
    VacationDTO getVacations(Integer id);
    VacationDTO createVacations(VacationDTO vacation);
    VacationDTO updateVacations(Integer id, VacationDTO vacation);
    VacationDTO deleteVacations(Integer id);
}
