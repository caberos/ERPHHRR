package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.Incidents;
import com.diplomado.springboot.dto.IncidentsDTO;

public class IncidentsMapper implements  CustomMapper<IncidentsDTO, Incidents>{
    @Override
    public IncidentsDTO toDto(Incidents incidents) {
        IncidentsDTO incidentsDTO = new IncidentsDTO();
        incidentsDTO.setIncidentId(incidents.getIncidentId());
        incidentsDTO.setIncidentDate(incidents.getIncidentDate());
        incidentsDTO.setEmployee(incidents.getEmployee());
        incidentsDTO.setDescription(incidents.getDescription());
        incidentsDTO.setLevel(incidents.getLevel());
        return incidentsDTO;
    }

    @Override
    public Incidents toEntity(IncidentsDTO incidentsDTO) {
        Incidents incidents = new Incidents();
        incidents.setIncidentId(incidentsDTO.getIncidentId());
        incidents.setIncidentDate(incidentsDTO.getIncidentDate());
        incidents.setEmployee(incidentsDTO.getEmployee());
        incidents.setDescription(incidentsDTO.getDescription());
        incidents.setLevel(incidentsDTO.getLevel());
        return incidents;
    }
}
