package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.IncidentsDTO;

import java.util.List;

public interface IncidentsServices {
    List<IncidentsDTO> listIncidents();
    IncidentsDTO getIncident(Integer id);
    IncidentsDTO createIncident(IncidentsDTO incident);
    IncidentsDTO updateIncident(Integer id, IncidentsDTO incident);
    IncidentsDTO deleteIncident(Integer id);
}
