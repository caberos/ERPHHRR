package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Incidents;
import com.diplomado.springboot.dto.IncidentsDTO;
import com.diplomado.springboot.repositories.IncidentsRepository;
import com.diplomado.springboot.services.IncidentsServices;
import com.diplomado.springboot.services.mapper.IncidentsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentsServicesImplement implements IncidentsServices {

    private final IncidentsMapper incidentsMapper;
    private final IncidentsRepository incidentsRepository;

    public IncidentsServicesImplement(IncidentsMapper incidentsMapper,
                                      IncidentsRepository incidentsRepository) {
        this.incidentsMapper = incidentsMapper;
        this.incidentsRepository = incidentsRepository;
    }

    @Override
    public List<IncidentsDTO> listIncidents() {
        return this.incidentsRepository.findAll()
                .stream().map(incidentsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public IncidentsDTO getIncident(Integer id) {
        List<Incidents> incidentsList = incidentsRepository.findAll();
        Incidents res = new Incidents();
        for (Incidents aux : incidentsList) {
            if (aux.getIncidentId() == id) {
                res = aux;
                break;
            }
        }
        return this.incidentsMapper.toDto(res);
    }

    @Override
    public IncidentsDTO createIncident(IncidentsDTO incident) {
        return this.incidentsMapper.toDto(
                incidentsRepository.save(this.incidentsMapper.toEntity(incident)));
    }

    @Override
    public IncidentsDTO updateIncident(Integer id, IncidentsDTO incidentsDTO) {
        Incidents incidents = incidentsRepository.getReferenceById(Long.valueOf(id));
        incidents.setIncidentId(incidentsDTO.getIncidentId());
        incidents.setIncidentDate(incidentsDTO.getIncidentDate());
        incidents.setEmployee(incidentsDTO.getEmployee());
        incidents.setDescription(incidentsDTO.getDescription());
        incidents.setLevel(incidentsDTO.getLevel());
        incidentsRepository.save(incidents);
        return this.incidentsMapper.toDto(incidents);
    }

    @Override
    public IncidentsDTO deleteIncident(Integer id) {
        List<Incidents> incidentsList = incidentsRepository.findAll();
        Incidents res = new Incidents();
        for (Incidents aux : incidentsList) {
            if (aux.getIncidentId() == id) {
                res = aux;
                incidentsRepository.deleteById(Long.valueOf(id));
                break;
            }
        }
        return this.incidentsMapper.toDto(res);
    }
}
