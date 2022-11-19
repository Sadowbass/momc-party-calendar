package com.momc.momc.service;

import com.momc.momc.entity.Event;
import com.momc.momc.entity.Member;
import com.momc.momc.model.dto.EventDto;
import com.momc.momc.model.form.CreateEventForm;
import com.momc.momc.model.form.JoinEventForm;
import com.momc.momc.repository.EventRepository;
import com.momc.momc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventCommandService {

    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;

    @Transactional
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

    @Transactional
    public void joinEvent(JoinEventForm form) {
        Event event = eventRepository.findById(form.getEventId()).orElseThrow(RuntimeException::new);
        Member member = new Member(form.getName(), form.getPosition());

        event.addMember(member);
        memberRepository.save(member);
        form.setMemberId(member.getId());
    }

    @Transactional
    public void removeMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        memberRepository.delete(member);
    }

    @Transactional
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(RuntimeException::new);
        memberRepository.deleteAllByEvent(event);
        eventRepository.delete(event);
    }
}
