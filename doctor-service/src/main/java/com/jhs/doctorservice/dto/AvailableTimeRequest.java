package com.jhs.doctorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailableTimeRequest {
    private String dayOfWeek;
    private LocalTime beginsAt;

    private LocalTime endsAt;

    private String room;
}
