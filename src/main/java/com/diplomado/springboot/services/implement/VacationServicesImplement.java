package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Vacations;
import com.diplomado.springboot.dto.VacationDTO;
import com.diplomado.springboot.repositories.VacationsRepository;
import com.diplomado.springboot.services.VacationsServices;
import com.diplomado.springboot.services.mapper.VacationsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationServicesImplement implements VacationsServices {

    private final VacationsRepository vacationsRepository;
    private final VacationsMapper vacationsMapper;

    public VacationServicesImplement(VacationsRepository vacationsRepository,
                                     VacationsMapper vacationsMapper) {
        this.vacationsRepository = vacationsRepository;
        this.vacationsMapper = vacationsMapper;
    }

    @Override
    public List<VacationDTO> listVacations() {
        return vacationsRepository.findAll()
                .stream().map(vacationsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public VacationDTO getVacations(Integer id) {
        List<Vacations> vacationsList = vacationsRepository.findAll();
        Vacations res = new Vacations();
        for (Vacations aux : vacationsList) {
            if (aux.getVacationId() == id) {
                res = aux;
                break;
            }
        }
        return this.vacationsMapper.toDto(res);
    }

    @Override
    public VacationDTO createVacations(VacationDTO vacationDTO) {
        return this.vacationsMapper.toDto(
                vacationsRepository.save(this.vacationsMapper.toEntity(vacationDTO)));
    }

    @Override
    public VacationDTO updateVacations(Integer id, VacationDTO vacation) {
        Vacations vacations = vacationsRepository.getReferenceById(Long.valueOf(id));
        vacations.setVacationId(vacation.getVacationId());
        vacations.setDuration(vacation.getDuration());
        vacations.setEmployee(vacation.getEmployee());
        vacations.setReason(vacation.getReason());
        vacations.setStartAt(vacation.getStartAt());
        vacations.setEndAt(vacation.getEndAt());
        vacationsRepository.save(vacations);
        return this.vacationsMapper.toDto(vacations);
    }

    @Override
    public VacationDTO deleteVacations(Integer id) {
        List<Vacations> vacationsList = vacationsRepository.findAll();
        Vacations res = new Vacations();
        for (Vacations aux : vacationsList) {
            if (aux.getVacationId() == id) {
                res = aux;
                vacationsRepository.deleteById(Long.valueOf(id));
                break;
            }
        }
        return this.vacationsMapper.toDto(res);
    }
}
