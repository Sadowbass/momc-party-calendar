package com.momc.momc.model.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long memberId;
    private String name;
    private String position;

    @QueryProjection
    public MemberDto(Long memberId, String name, String position) {
        this.memberId = memberId;
        this.name = name;
        this.position = position;
    }
}
