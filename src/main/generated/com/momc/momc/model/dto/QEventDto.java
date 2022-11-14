package com.momc.momc.model.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.momc.momc.model.dto.QEventDto is a Querydsl Projection type for EventDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QEventDto extends ConstructorExpression<EventDto> {

    private static final long serialVersionUID = 1418577382L;

    public QEventDto(com.querydsl.core.types.Expression<Long> eventId, com.querydsl.core.types.Expression<String> requestBy, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> difficulty, com.querydsl.core.types.Expression<String> partyType, com.querydsl.core.types.Expression<java.time.LocalDate> eventDate, com.querydsl.core.types.Expression<java.time.LocalTime> eventTime, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<? extends java.util.List<MemberDto>> members) {
        super(EventDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, java.time.LocalDate.class, java.time.LocalTime.class, String.class, java.util.List.class}, eventId, requestBy, content, difficulty, partyType, eventDate, eventTime, comment, members);
    }

}

