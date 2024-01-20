package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Vacations;
import com.diplomado.springboot.dto.VacationDTO;
import org.springframework.stereotype.Component;

@Component
public class VacationsMapper implements  CustomMapper<VacationDTO, Vacations>{
    @Override
    public VacationDTO toDto(Vacations vacations) {
        VacationDTO vacationDTO = new VacationDTO();
        vacationDTO.setVacationId(vacations.getVacationId());
        vacationDTO.setDuration(vacations.getDuration());
        vacationDTO.setEmployee(vacations.getEmployee());
        vacationDTO.setReason(vacations.getReason());
        vacationDTO.setStartAt(vacations.getStartAt());
        vacationDTO.setEndAt(vacations.getEndAt());
        return vacationDTO;
    }

    @Override
    public Vacations toEntity(VacationDTO vacationDTO) {
        Vacations vacation = new Vacations();
        vacation.setVacationId(vacationDTO.getVacationId());
        vacation.setDuration(vacationDTO.getDuration());
        vacation.setEmployee(vacationDTO.getEmployee());
        vacation.setReason(vacationDTO.getReason());
        vacation.setStartAt(vacationDTO.getStartAt());
        vacation.setEndAt(vacationDTO.getEndAt());
        return vacation;
    }
}
