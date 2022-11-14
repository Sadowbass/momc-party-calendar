package com.momc.momc.service;

import com.momc.momc.entity.Event;
import com.momc.momc.entity.Member;
import com.momc.momc.model.dto.EventDto;
import com.momc.momc.model.form.CreateEventForm;
import com.momc.momc.model.form.JoinEventForm;
import com.momc.momc.model.form.RemoveUserForm;
import com.momc.momc.repository.EventRepository;
import com.momc.momc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventCommandService {

    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;

    public EventDto createEvent(CreateEventForm form) {
        Event newEvent = new Event.Builder()
                .requestBy(form.getRequestBy())
                .content(form.getContent())
                .difficulty(form.getDifficulty())
                .partyType(form.getPartyType())
                .eventDate(form.getEventDate())
                .eventTime(form.getEventTime())
                .comment(form.getComment()).build();

        Member member = new Member(form.getRequestBy(), form.getPosition());
        newEvent.addMember(member);

        eventRepository.save(newEvent);
        memberRepository.save(member);

        return EventDto.convertEventToDto(newEvent);
    }

    public void joinEvent(JoinEventForm form) {
        Event event = eventRepository.findById(form.getEventId()).orElseThrow(RuntimeException::new);
        Member member = new Member(form.getName(), form.getPosition());

        event.addMember(member);
        memberRepository.save(member);
        form.setMemberId(member.getId());
    }

    public void removeMember(RemoveUserForm form) {
        Member member = memberRepository.findById(form.getMemberId()).orElseThrow(RuntimeException::new);
        memberRepository.delete(member);
    }
}
