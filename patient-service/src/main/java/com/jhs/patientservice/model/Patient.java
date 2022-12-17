package com.jhs.patientservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "tb_patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String familyName;

    @NotBlank
    private String givenName;

    @NotBlank
    private LocalDate birthDate;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String email;
}
