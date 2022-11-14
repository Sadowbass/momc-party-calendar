package com.momc.momc.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = 1765096828L;

    public static final QEvent event = new QEvent("event");

    public final StringPath comment = createString("comment");

    public final StringPath content = createString("content");

    public final StringPath difficulty = createString("difficulty");

    public final DatePath<java.time.LocalDate> eventDate = createDate("eventDate", java.time.LocalDate.class);

    public final NumberPath<Long> eventId = createNumber("eventId", Long.class);

    public final TimePath<java.time.LocalTime> eventTime = createTime("eventTime", java.time.LocalTime.class);

    public final ListPath<Member, QMember> members = this.<Member, QMember>createList("members", Member.class, QMember.class, PathInits.DIRECT2);

    public final StringPath partyType = createString("partyType");

    public final StringPath requestBy = createString("requestBy");

    public QEvent(String variable) {
        super(Event.class, forVariable(variable));
    }

    public QEvent(Path<? extends Event> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvent(PathMetadata metadata) {
        super(Event.class, metadata);
    }

}

