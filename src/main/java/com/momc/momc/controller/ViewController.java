package com.momc.momc.controller;

import com.momc.momc.model.dto.DateDto;
import com.momc.momc.service.EventQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final EventQueryService eventQueryService;

    @GetMapping("/")
    public String index(Model model) {
        Map<LocalDate, DateDto> eventMap = eventQueryService.getEventsBetweenStartAndEnd(LocalDate.now());
        model.addAttribute("data", eventMap);
        return "index";
    }
}
