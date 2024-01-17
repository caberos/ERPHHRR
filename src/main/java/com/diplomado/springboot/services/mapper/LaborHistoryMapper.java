package com.diplomado.springboot.services.mapper;

import com.diplomado.springboot.domain.entities.LaborHistory;
import com.diplomado.springboot.dto.LaborHistoryDTO;

public class LaborHistoryMapper implements CustomMapper<LaborHistoryDTO, LaborHistory>{
    @Override
    public LaborHistoryDTO toDto(LaborHistory laborHistory) {
        LaborHistoryDTO laborHistoryDTO = new LaborHistoryDTO();
        laborHistoryDTO.setHistoryId(laborHistory.getHistoryId());
        laborHistoryDTO.setEmployee(laborHistory.getEmployee());
        laborHistoryDTO.setDescription(laborHistory.getDescription());
        laborHistoryDTO.setEndAt(laborHistory.getEndAt());
        laborHistoryDTO.setPostId(laborHistory.getPostId());
        laborHistoryDTO.setStartAt(laborHistory.getStartAt());
        return laborHistoryDTO;
    }

    @Override
    public LaborHistory toEntity(LaborHistoryDTO laborHistoryDTO) {
        LaborHistory laborHistory = new LaborHistory();
        laborHistory.setHistoryId(laborHistoryDTO.getHistoryId());
        laborHistory.setEmployee(laborHistoryDTO.getEmployee());
        laborHistory.setDescription(laborHistoryDTO.getDescription());
        laborHistory.setEndAt(laborHistoryDTO.getEndAt());
        laborHistory.setPostId(laborHistoryDTO.getPostId());
        laborHistory.setStartAt(laborHistoryDTO.getStartAt());
        return laborHistory;
    }
}
