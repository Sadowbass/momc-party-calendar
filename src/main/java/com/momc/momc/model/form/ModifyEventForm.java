package com.momc.momc.model.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ModifyEventForm {

    private LocalDate eventDate;
    private LocalTime eventTime;
    private String content;
    private String difficulty;
    private String partyType;
    private String comment;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModifyEventForm{");
        sb.append("eventDate=").append(eventDate);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", content='").append(content).append('\'');
        sb.append(", difficulty='").append(difficulty).append('\'');
        sb.append(", partyType='").append(partyType).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
