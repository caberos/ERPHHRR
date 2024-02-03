package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.AccomplishmentDTO;

import java.util.List;

public interface AccomplishmentsServices {
    List<AccomplishmentDTO> listAccomplishment();

    List<AccomplishmentDTO> listAccomplishmentByEmployeeID(Integer employeeId);

    AccomplishmentDTO getAccomplishment(Integer id);
    AccomplishmentDTO createAccomplishment(AccomplishmentDTO accomplishment);
    AccomplishmentDTO updateAccomplishment(Integer id, AccomplishmentDTO accomplishment);
    AccomplishmentDTO deleteAccomplishment(Integer id);
}
