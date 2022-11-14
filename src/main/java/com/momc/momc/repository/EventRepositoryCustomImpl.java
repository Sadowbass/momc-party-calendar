package com.momc.momc.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momc.momc.model.dto.EventDto;
import com.momc.momc.model.dto.QEventDto;
import com.momc.momc.model.dto.QMemberDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static com.momc.momc.entity.QEvent.event;
import static com.momc.momc.entity.QMember.member;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Component
@Slf4j
public class EventRepositoryCustomImpl implements EventRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    @Autowired
    private ObjectMapper om;

    public EventRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @PostConstruct
    public void init() {
        log.info("em data = {}", em.toString());
    }

    public List<EventDto> findAllDtoByEventDateBetween(LocalDate start, LocalDate end) {
        return queryFactory
                .from(event)
                .join(event.members, member)
                .where(event.eventDate.between(start, end))
                .transform(
                        groupBy(event.eventDate).list(
                                new QEventDto(
                                        event.eventId,
                                        event.requestBy,
                                        event.content,
                                        event.difficulty,
                                        event.partyType,
                                        event.eventDate,
                                        event.eventTime,
                                        event.comment,
                                        list(
                                                new QMemberDto(
                                                        member.id.as("memberId"),
                                                        member.name.as("name"),
                                                        member.position.as("position")
                                                )
                                        )
                                )
                        )
                );
    }
}
