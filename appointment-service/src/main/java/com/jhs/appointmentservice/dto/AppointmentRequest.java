package com.jhs.appointmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {
    private Long doctorId;

    private String doctorName;

    private Long patientId;

    private String patientName;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;
}
