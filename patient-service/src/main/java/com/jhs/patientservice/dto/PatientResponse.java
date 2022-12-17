package com.jhs.patientservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientResponse {
    private Long id;

    private String familyName;

    private String givenName;

    private LocalDate birthDate;

    private String phoneNumber;

    private String email;
}
