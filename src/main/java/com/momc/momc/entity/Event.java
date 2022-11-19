package com.momc.momc.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @GeneratedValue
    private Long eventId;
    private String requestBy;
    private String content;
    private String difficulty;
    private String partyType;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String comment;

    @OneToMany(mappedBy = "event")
    private List<Member> members = new ArrayList<>();

    private Event(Event.Builder builder) {
        this.requestBy = builder.requestBy;
        this.content = builder.content;
        this.difficulty = builder.difficulty;
        this.partyType = builder.partyType;
        this.eventDate = builder.eventDate;
        this.eventTime = builder.eventTime;
        this.comment = builder.comment;
    }

    public void addMember(Member member) {
        this.members.add(member);
        member.joinEvent(this);
    }

    public void changeEventData(String content, String difficulty, String partyType, LocalDate eventDate, LocalTime eventTime, String comment) {
        this.content = content;
        this.difficulty = difficulty;
        this.partyType = partyType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.comment = comment;
    }

    public void addAllMember(Member... members) {
        Arrays.stream(members).forEach(this::addMember);
    }

    @NoArgsConstructor
    public static class Builder {

        private String requestBy;
        private String content;
        private String difficulty;
        private String partyType;
        private LocalDate eventDate;
        private LocalTime eventTime;
        private String comment;

        public Event.Builder requestBy(String requestBy) {
            this.requestBy = requestBy;
            return this;
        }

        public Event.Builder content(String content) {
            this.content = content;
            return this;
        }

        public Event.Builder difficulty(String difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Event.Builder partyType(String partyType) {
            this.partyType = partyType;
            return this;
        }

        public Event.Builder eventDate(LocalDate eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Event.Builder eventTime(LocalTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Event.Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("eventId=").append(eventId);
        sb.append(", requestBy='").append(requestBy).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", difficulty='").append(difficulty).append('\'');
        sb.append(", partyType='").append(partyType).append('\'');
        sb.append(", eventDate=").append(eventDate);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", members=").append(members);
        sb.append('}');
        return sb.toString();
    }
}
