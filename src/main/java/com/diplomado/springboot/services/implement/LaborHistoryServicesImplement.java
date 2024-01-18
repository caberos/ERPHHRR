package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Evaluation;
import com.diplomado.springboot.domain.entities.Incidents;
import com.diplomado.springboot.domain.entities.LaborHistory;
import com.diplomado.springboot.dto.LaborHistoryDTO;
import com.diplomado.springboot.repositories.LaborHistoryRepository;
import com.diplomado.springboot.services.LaborHistoryServices;
import com.diplomado.springboot.services.mapper.LaborHistoryMapper;

import java.util.List;
import java.util.stream.Collectors;

public class LaborHistoryServicesImplement implements LaborHistoryServices {

    private final LaborHistoryMapper laborHistoryMapper;
    private final LaborHistoryRepository laborHistoryRepository;

    public LaborHistoryServicesImplement(LaborHistoryMapper laborHistoryMapper,
                                         LaborHistoryRepository laborHistoryRepository) {
        this.laborHistoryMapper = laborHistoryMapper;
        this.laborHistoryRepository = laborHistoryRepository;
    }

    @Override
    public List<LaborHistoryDTO> listLaborHistories() {
        return this.laborHistoryRepository.findAll()
                .stream().map(laborHistoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LaborHistoryDTO getLaborHistory(Integer id) {
        List<LaborHistory> laborHistories = laborHistoryRepository.findAll();
        LaborHistory res = new LaborHistory();
        for (LaborHistory aux : laborHistories) {
            if (aux.getHistoryId() == id) {
                res = aux;
                break;
            }
        }
        return this.laborHistoryMapper.toDto(res);
    }

    @Override
    public LaborHistoryDTO createLaborHistory(LaborHistoryDTO laborHistory) {
        return this.laborHistoryMapper.toDto(
                laborHistoryRepository.save(this.laborHistoryMapper.toEntity(laborHistory)));
    }

    @Override
    public LaborHistoryDTO updateLaborHistory(Integer id, LaborHistoryDTO laborHistoryDTO) {
        LaborHistory laborHistory = laborHistoryRepository.getReferenceById(id);
        laborHistory.setHistoryId(laborHistoryDTO.getHistoryId());
        laborHistory.setEmployee(laborHistoryDTO.getEmployee());
        laborHistory.setDescription(laborHistoryDTO.getDescription());
        laborHistory.setEndAt(laborHistoryDTO.getEndAt());
        laborHistory.setPostId(laborHistoryDTO.getPostId());
        laborHistory.setStartAt(laborHistoryDTO.getStartAt());
        laborHistoryRepository.save(laborHistory);
        return this.laborHistoryMapper.toDto(laborHistory);
    }

    @Override
    public LaborHistoryDTO deleteLaborHistory(Integer id) {
        List<LaborHistory> laborHistories = laborHistoryRepository.findAll();
        LaborHistory res = new LaborHistory();
        for (LaborHistory aux : laborHistories) {
            if (aux.getHistoryId() == id) {
                res = aux;
                laborHistoryRepository.deleteById(id);
                break;
            }
        }
        return this.laborHistoryMapper.toDto(res);
    }
}
