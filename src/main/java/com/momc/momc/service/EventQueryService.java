package com.momc.momc.service;

import com.momc.momc.model.dto.DateDto;
import com.momc.momc.model.dto.EventDto;
import com.momc.momc.model.dto.MemberDto;
import com.momc.momc.repository.JPAEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor
@Service
public class EventQueryService {

    private final JPAEventRepository eventRepository;

    public Map<LocalDate, DateDto> getEventsBetweenStartAndEnd(LocalDate now) {
        List<EventDto> events = eventRepository.findAllDtoByEventDateBetween(createStartLocalDate(now), createEndLocalDate(now));
        Map<LocalDate, DateDto> map = new HashMap<>();

        events.forEach(event -> {
            if (!Objects.isNull(event.getMembers())) {
                List<MemberDto> members = event.getMembers();
                members.removeIf(member -> null == member.getMemberId());
            } else {
                event.setMembers(new ArrayList<>());
            }

            LocalDate key = event.getEventDate();
            if (map.containsKey(key)) {
                map.get(key).addEvent(event);
            } else {
                DateDto dateDto = new DateDto();
                dateDto.setDate(event.getEventDate());
                dateDto.addEvent(event);
                map.put(key, dateDto);
            }
        });

        return map;
    }

    private LocalDate createStartLocalDate(LocalDate now) {
        LocalDate startMonth = now.minusMonths(1);
        return startMonth.withDayOfMonth(1);
    }

    private LocalDate createEndLocalDate(LocalDate now) {
        LocalDate endMonth = now.plusMonths(1);
        return endMonth.withDayOfMonth(endMonth.lengthOfMonth());
    }
}
