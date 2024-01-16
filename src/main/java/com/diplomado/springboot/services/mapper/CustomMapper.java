package com.diplomado.springboot.services.mapper;

public interface CustomMapper <DTO, E>{
    DTO toDto(E e);

    E ToEntity(DTO dto);
}
