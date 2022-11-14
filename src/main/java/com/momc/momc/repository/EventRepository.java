package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import org.springframework.data.jpa.repository.EntityGraph;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventRepository {

    Event save(Event event);

    Optional<Event> findById(Long id);

    @EntityGraph(attributePaths = {"members"})
    List<Event> findAll();

    void delete(Event event);

    List<Event> findAllByEventDateBetween(LocalDate start, LocalDate end);
}
