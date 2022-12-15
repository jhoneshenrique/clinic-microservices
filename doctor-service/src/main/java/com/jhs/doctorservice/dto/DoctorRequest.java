package com.jhs.doctorservice.dto;

import com.jhs.doctorservice.model.AvailableTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private String familyName;

    private String givenName;

    private LocalDate birthDate;

    private String specialty;

    private List<AvailableTime> agenda;
}
