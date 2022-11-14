package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import com.momc.momc.entity.Member;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PureJavaEventRepository implements EventRepository {

    private List<Event> repository = new ArrayList<>();
    private Long idSequence = 1L;

    @Override
    public Event save(Event event) {
        try {
            Field eventIdField = event.getClass().getDeclaredField("eventId");
            eventIdField.setAccessible(true);
            eventIdField.set(event, idSequence++);
            repository.add(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public Optional<Event> findById(Long id) {
        return repository.stream()
                .filter(event -> Objects.equals(event.getEventId(), id))
                .findFirst();
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void delete(Event event) {
        Optional<Event> result = repository.stream()
                .filter(element -> element.getEventId().equals(event.getEventId()))
                .findFirst();

        result.ifPresent(value -> repository.remove(value));
    }

    @Override
    public List<Event> findAllByEventDateBetween(LocalDate start, LocalDate end) {
        return repository
                .stream()
                .filter(event -> event.getEventDate().compareTo(start) >= 0 && event.getEventDate().compareTo(end) <= 0)
                .collect(Collectors.toList());
    }
}
