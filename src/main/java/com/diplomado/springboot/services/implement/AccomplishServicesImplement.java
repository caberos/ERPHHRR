package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Accomplishments;
import com.diplomado.springboot.domain.entities.Vacations;
import com.diplomado.springboot.dto.AccomplishmentDTO;
import com.diplomado.springboot.repositories.AccomplishmentsRepository;
import com.diplomado.springboot.services.AccomplishmentsServices;
import com.diplomado.springboot.services.mapper.AccomplishmentMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AccomplishServicesImplement implements AccomplishmentsServices {

    private final AccomplishmentsRepository accomplishmentsRepository;
    private final AccomplishmentMapper accomplishmentMapper;

    public AccomplishServicesImplement(AccomplishmentsRepository accomplishmentsRepository,
                                       AccomplishmentMapper accomplishmentMapper) {
        this.accomplishmentsRepository = accomplishmentsRepository;
        this.accomplishmentMapper = accomplishmentMapper;
    }

    @Override
    public List<AccomplishmentDTO> listAccomplishment() {
        return accomplishmentsRepository.findAll()
                .stream().map(accomplishmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AccomplishmentDTO getAccomplishment(Integer id) {
        List<Accomplishments> accomplishmentsList = accomplishmentsRepository.findAll();
        Accomplishments res = new Accomplishments();
        for (Accomplishments aux : accomplishmentsList) {
            if (aux.getAccomplishmentId() == id) {
                res = aux;
                break;
            }
        }
        return this.accomplishmentMapper.toDto(res);
    }

    @Override
    public AccomplishmentDTO createAccomplishment(AccomplishmentDTO accomplishment) {
        return this.accomplishmentMapper.toDto(
                accomplishmentsRepository.save(this.accomplishmentMapper.toEntity(accomplishment)));
    }

    @Override
    public AccomplishmentDTO updateAccomplishment(Integer id, AccomplishmentDTO accomplishment) {
        Accomplishments accomplishments = accomplishmentsRepository.getReferenceById(id);
        accomplishments.setAccomplishmentId(accomplishment.getAccomplishmentId());
        accomplishments.setAccomplishmentDate(accomplishment.getAccomplishmentDate());
        accomplishments.setDescription(accomplishment.getDescription());
        accomplishments.setEmployee(accomplishment.getEmployee());
        accomplishmentsRepository.save(accomplishments);
        return this.accomplishmentMapper.toDto(accomplishments);

    }

    @Override
    public AccomplishmentDTO deleteAccomplishment(Integer id) {
        List<Accomplishments> accomplishmentsList = accomplishmentsRepository.findAll();
        Accomplishments res = new Accomplishments();
        for (Accomplishments aux : accomplishmentsList) {
            if (aux.getAccomplishmentId() == id) {
                res = aux;
                accomplishmentsRepository.deleteById(id);
                break;
            }
        }
        return this.accomplishmentMapper.toDto(res);
    }
}
