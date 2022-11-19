package com.momc.momc.controller;

import com.momc.momc.entity.Event;
import com.momc.momc.model.dto.ApiResult;
import com.momc.momc.model.dto.EventDto;
import com.momc.momc.model.form.CreateEventForm;
import com.momc.momc.model.form.JoinEventForm;
import com.momc.momc.model.form.ModifyEventForm;
import com.momc.momc.repository.EventRepository;
import com.momc.momc.service.EventCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final EventCommandService commandService;
    private final EventRepository eventRepository;

    @PostMapping("/events")
    public ApiResult<EventDto> createEvent(@Valid @RequestBody CreateEventForm form) {
        return new ApiResult<>(0, "test", commandService.createEvent(form));
    }

    @PutMapping("/events/{eventId}")
    @Transactional
    public ApiResult<EventDto> modifyEvent(@PathVariable Long eventId, @RequestBody ModifyEventForm form) {
        Event event = eventRepository.findById(eventId).orElseThrow(RuntimeException::new);
        event.changeEventData(
                form.getContent(),
                form.getDifficulty(),
                form.getPartyType(),
                form.getEventDate(),
                form.getEventTime(),
                form.getComment());

        EventDto eventDto = EventDto.convertEventToDto(event);
        return new ApiResult<>(0, "test", eventDto);
    }

    @DeleteMapping("/events/{eventId}")
    public ApiResult<Void> deleteEvent(@PathVariable Long eventId) {
        commandService.deleteEvent(eventId);
        return new ApiResult<>(0, "test", null);
    }

    @PostMapping("/events/{eventId}/members")
    public ApiResult<JoinEventForm> joinEvent(@RequestBody JoinEventForm form) {
        commandService.joinEvent(form);
        return new ApiResult<>(0, "test", form);
    }

    @DeleteMapping("/events/{eventId}/members/{memberId}")
    public ApiResult<Void> removeMember(@PathVariable Long memberId) {
        commandService.removeMember(memberId);
        return new ApiResult<>(0, "test", null);
    }
}
