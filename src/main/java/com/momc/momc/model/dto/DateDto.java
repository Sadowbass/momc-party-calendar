package com.momc.momc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DateDto {

    private LocalDate date;
    private List<EventDto> events = new ArrayList<>();

    public void addEvent(EventDto eventDto) {
        this.events.add(eventDto);
    }
}
