package com.momc.momc.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {

    @JsonProperty("rsp-code")
    private int rspCode;

    @JsonProperty("rsp-message")
    private String rspMsg;

    T result;
}
