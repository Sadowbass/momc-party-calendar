package com.momc.momc.model.dto;

import com.momc.momc.entity.Event;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventDto {

    private Long eventId;
    private String requestBy;
    private String content;
    private String difficulty;
    private String partyType;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String comment;
    private List<MemberDto> members = new ArrayList<>();

    @QueryProjection
    public EventDto(Long eventId, String requestBy, String content, String difficulty, String partyType, LocalDate eventDate, LocalTime eventTime, String comment, List<MemberDto> members) {
        this.eventId = eventId;
        this.requestBy = requestBy;
        this.content = content;
        this.difficulty = difficulty;
        this.partyType = partyType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.comment = comment;
        this.members = members;
    }

    public static EventDto convertEventToDto(Event event) {
        EventDto dto = new EventDto();

        dto.setEventId(event.getEventId());
        dto.setRequestBy(event.getRequestBy());
        dto.setContent(event.getContent());
        dto.setDifficulty(event.getDifficulty());
        dto.setPartyType(event.getPartyType());
        dto.setEventDate(event.getEventDate());
        dto.setEventTime(event.getEventTime());
        dto.setComment(event.getComment());
        event.getMembers().stream()
                .map(member -> new MemberDto(member.getId(), member.getName(), member.getPosition()))
                .forEach(memberDto -> dto.members.add(memberDto));

        return dto;
    }
}
