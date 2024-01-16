package com.diplomado.springboot.services;

import com.diplomado.springboot.dto.LaborHistoryDTO;

import java.util.List;

public interface LaborHistoryServices {
    List<LaborHistoryDTO> listLaborHistories();

    LaborHistoryDTO getLaborHistory(Integer id);

    LaborHistoryDTO createLaborHistory(LaborHistoryDTO laborHistory);

    LaborHistoryDTO updateLaborHistory(Integer id, LaborHistoryDTO laborHistory);

    LaborHistoryDTO deleteLaborHistory(Integer id);
}
