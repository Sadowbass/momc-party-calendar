package com.momc.momc.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventForm {

    @NotBlank
    private String requestBy;

    @NotBlank
    private String content;
    private String difficulty;
    private String partyType;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime eventTime;
    private String comment;

    @NotBlank
    private String position;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateEventForm{");
        sb.append("requestBy='").append(requestBy).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", difficulty='").append(difficulty).append('\'');
        sb.append(", partyType='").append(partyType).append('\'');
        sb.append(", eventDate=").append(eventDate);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
