package com.momc.momc.model.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinEventForm {

    private Long eventId;
    private Long memberId;
    private String name;
    private String position;
}
