package com.momc.momc.repository;

import com.momc.momc.model.dto.EventDto;

import java.time.LocalDate;
import java.util.List;

public interface EventRepositoryCustom {

    List<EventDto> findAllDtoByEventDateBetween(LocalDate start, LocalDate end);
}
