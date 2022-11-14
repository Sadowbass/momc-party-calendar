package com.momc.momc.model.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.momc.momc.model.dto.QMemberDto is a Querydsl Projection type for MemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDto extends ConstructorExpression<MemberDto> {

    private static final long serialVersionUID = -1957495804L;

    public QMemberDto(com.querydsl.core.types.Expression<Long> memberId, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> position) {
        super(MemberDto.class, new Class<?>[]{long.class, String.class, String.class}, memberId, name, position);
    }

}

