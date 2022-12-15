package com.jhs.doctorservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jhs.doctorservice.model.AvailableTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorResponse extends RepresentationModel {

    private long id;

    private String familyName;

    private String givenName;

    private LocalDate birthDate;

    private String specialty;

    private List<AvailableTime> agenda;
}
