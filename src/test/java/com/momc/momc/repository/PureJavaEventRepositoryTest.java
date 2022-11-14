package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PureJavaEventRepositoryTest {

    @Test
    void saveTest() throws Exception {
        //given
        EventRepository eventRepository = new PureJavaEventRepository();
        Event.Builder builder = new Event.Builder();
        Event event = builder.requestBy("test").build();

        //when
        assertThat(event.getEventId()).isNull();
        eventRepository.save(event);

        //then
        assertThat(event.getEventId()).isNotNull().isInstanceOf(Long.class);
    }

    @Test
    void findByIdTest() throws Exception {
        //given
        EventRepository eventRepository = new PureJavaEventRepository();
        Event event1 = new Event.Builder().requestBy("test1").build();
        Event event2 = new Event.Builder().requestBy("test2").build();
        Event event3 = new Event.Builder().requestBy("test3").build();

        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
        //when
        Event foundedEvent1 = eventRepository.findById(event1.getEventId()).get();
        Event foundedEvent2 = eventRepository.findById(event2.getEventId()).get();
        Event foundedEvent3 = eventRepository.findById(event3.getEventId()).get();

        //then
        assertThat(foundedEvent1.getEventId()).isEqualTo(event1.getEventId());
        assertThat(foundedEvent2.getEventId()).isEqualTo(event2.getEventId());
        assertThat(foundedEvent3.getEventId()).isEqualTo(event3.getEventId());
    }

    @Test
    void findAllTest() throws Exception {
        //given
        EventRepository eventRepository = new PureJavaEventRepository();
        Event event1 = new Event.Builder().requestBy("test1").build();
        Event event2 = new Event.Builder().requestBy("test2").build();
        Event event3 = new Event.Builder().requestBy("test3").build();

        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);

        //when
        List<Event> result = eventRepository.findAll();

        //then
        assertThat(result).hasSize(3).contains(event1, event2, event3);
    }

    @Test
    void deleteTest() throws Exception {
        //given
        EventRepository eventRepository = new PureJavaEventRepository();
        Event event1 = new Event.Builder().requestBy("test1").build();
        Event event2 = new Event.Builder().requestBy("test2").build();
        Event event3 = new Event.Builder().requestBy("test3").build();

        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);

        //when
        Event event4 = new Event.Builder().requestBy("test4").build();

        //then
        List<Event> savedData = eventRepository.findAll();
        assertThat(savedData).hasSize(2).contains(event1, event3).doesNotContain(event2, event4);
    }

    @Test
    void findByLocalDateBetween() throws Exception {
        //given
        EventRepository eventRepository = new PureJavaEventRepository();
        Event eventSeptember = new Event.Builder()
                .requestBy("eventSeptember")
                .eventDate(LocalDate.of(2022, 9, 30))
                .build();
        Event eventOctober = new Event.Builder()
                .requestBy("eventOctober")
                .eventDate(LocalDate.of(2022, 10, 1))
                .build();
        Event eventNovember = new Event.Builder()
                .requestBy("eventNovember")
                .eventDate(LocalDate.of(2022, 11, 30))
                .build();
        Event eventDecember = new Event.Builder()
                .requestBy("eventDecember")
                .eventDate(LocalDate.of(2022, 12, 31))
                .build();
        Event eventJanuary = new Event.Builder()
                .requestBy("eventJanuary")
                .eventDate(LocalDate.of(2023, 1, 1))
                .build();

        eventRepository.save(eventSeptember);
        eventRepository.save(eventOctober);
        eventRepository.save(eventNovember);
        eventRepository.save(eventDecember);
        eventRepository.save(eventJanuary);

        //when
        List<Event> result = eventRepository.findAllByEventDateBetween(
                LocalDate.of(2022, 10, 1),
                LocalDate.of(2022, 12, 31));

        //then
        assertThat(eventRepository.findAll())
                .hasSize(5)
                .contains(eventSeptember, eventOctober, eventNovember, eventDecember, eventJanuary);

        assertThat(result)
                .hasSize(3)
                .contains(eventOctober, eventNovember, eventDecember)
                .doesNotContain(eventSeptember, eventJanuary);
    }
}