package com.momc.momc.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    private String name;
    private String position;

    public Member(String name, String position) {
        this.name = name;
        this.position = position;
    }

    void joinEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("id=").append(id);
        sb.append(", event=").append(event.getEventId());
        sb.append(", name='").append(name).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
