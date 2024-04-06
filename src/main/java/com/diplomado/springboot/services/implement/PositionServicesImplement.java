package com.diplomado.springboot.services.implement;

import com.diplomado.springboot.domain.entities.Position;
import com.diplomado.springboot.dto.PositionDTO;
import com.diplomado.springboot.repositories.PositionRepository;
import com.diplomado.springboot.services.PositionServices;
import com.diplomado.springboot.services.mapper.PositionMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServicesImplement implements PositionServices {
    private final PositionMapper positionMapper;
    private final PositionRepository positionRepository;

    public PositionServicesImplement(PositionMapper positionMapper,
                                     PositionRepository positionRepository) {
        this.positionMapper = positionMapper;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionDTO> listPositions() {
        return this.positionRepository.findAll()
                .stream().map(positionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PositionDTO getPosition(Integer id) {
        List<Position> positionList = positionRepository.findAll();
        Position res = new Position();
        for (Position aux : positionList) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
        }
        return this.positionMapper.toDto(res);
    }

    @Override
    public PositionDTO createPosition(PositionDTO position) {
        return this.positionMapper.toDto(
                positionRepository.save(this.positionMapper.toEntity(position)));
    }

    @Override
    public PositionDTO updatePosition(Integer id, PositionDTO positionDTO) {
        Position position = positionRepository.getReferenceById(Long.valueOf(id));
        position.setId(positionDTO.getId());
        position.setName(positionDTO.getName());
        position.setDepartment(positionDTO.getDepartment());
        position.setEmployee(positionDTO.getEmployee());
        position.setEquipment(positionDTO.getEquipment());
        position.setSalary(positionDTO.getSalary());
        position.setDescription(positionDTO.getDescription());
        positionRepository.save(position);
        return this.positionMapper.toDto(position);
    }

    @Override
    public PositionDTO deletePosition(Integer id) {
        List<Position> positionList = positionRepository.findAll();
        Position res = new Position();
        for (Position aux : positionList) {
            if (aux.getId() == id) {
                res = aux;
                positionRepository.deleteById(Long.valueOf(id));
                break;
            }
        }
        return this.positionMapper.toDto(res);
    }

    @Override
    public List<PositionDTO> getPositionByEmployeeId(Integer employeeId) {
        List<Position> positionList = positionRepository.findAll();
        List<PositionDTO> res = new ArrayList<>();
        for (Position aux : positionList) {
            if (aux.getEmployee().getId() == employeeId) {
                res.add(this.positionMapper.toDto(aux));
            }
        }
        return res;
    }
}
