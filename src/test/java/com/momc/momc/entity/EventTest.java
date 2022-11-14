package com.momc.momc.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    void createEvent() throws Exception {
        //given
        String requestBy = "개발하다샷건침";
        String content = "아브렐슈드";
        String difficulty = "노말";
        String partyType = "반숙";
        LocalDate eventDate = LocalDate.of(2022, 11, 11);
        LocalTime eventTime = LocalTime.of(11, 10);

        //when
        Event.Builder builder = new Event.Builder();
        Event event = builder
                .requestBy(requestBy).content(content).difficulty(difficulty)
                .partyType(partyType).eventDate(eventDate).eventTime(eventTime)
                .build();

        //then
        assertThat(event.getRequestBy()).isEqualTo(requestBy);
        assertThat(event.getContent()).isEqualTo(content);
        assertThat(event.getDifficulty()).isEqualTo(difficulty);
        assertThat(event.getPartyType()).isEqualTo(partyType);
        assertThat(event.getEventDate()).isEqualTo(eventDate);
        assertThat(event.getEventTime()).isEqualTo(eventTime);
    }

    @Test
    void addMember() throws Exception {
        //given
        String requestBy = "개발하다샷건침";
        String content = "아브렐슈드";
        String difficulty = "노말";
        String partyType = "반숙";
        LocalDate eventDate = LocalDate.of(2022, 11, 11);
        LocalTime eventTime = LocalTime.of(11, 10);

        String position = "딜";
        Member member = new Member(requestBy, position);

        //when
        Event.Builder builder = new Event.Builder();
        Event event = builder
                .requestBy(requestBy).content(content).difficulty(difficulty)
                .partyType(partyType).eventDate(eventDate).eventTime(eventTime)
                .build();

        event.addMember(member);

        //then
        assertThat(event.getMembers()).hasSize(1);
        assertThat(event.getMembers().get(0)).isEqualTo(member);
    }
}