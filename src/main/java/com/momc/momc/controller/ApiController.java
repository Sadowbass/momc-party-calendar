package com.momc.momc.controller;

import com.momc.momc.model.dto.ApiResult;
import com.momc.momc.model.dto.EventDto;
import com.momc.momc.model.form.CreateEventForm;
import com.momc.momc.model.form.JoinEventForm;
import com.momc.momc.model.form.RemoveUserForm;
import com.momc.momc.service.EventCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final EventCommandService commandService;

    @PostMapping("/createEvent")
    public ApiResult<EventDto> createEvent(@Valid @RequestBody CreateEventForm form) {
        return new ApiResult<>(0, "test", commandService.createEvent(form));
    }

    @PostMapping("/joinEvent")
    public ApiResult<JoinEventForm> joinEvent(@RequestBody JoinEventForm form) {
        commandService.joinEvent(form);
        return new ApiResult<>(0, "test", form);
    }

    @PostMapping("removeMember")
    public ApiResult<RemoveUserForm> removeMember(@RequestBody RemoveUserForm form) {
        commandService.removeMember(form);
        return new ApiResult<>(0, "test", form);
    }
}
