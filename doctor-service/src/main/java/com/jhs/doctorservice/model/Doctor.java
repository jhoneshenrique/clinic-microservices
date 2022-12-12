package com.jhs.doctorservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String familyName;
    @NotBlank
    private String givenName;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private String specialty;

    @ManyToMany
    @JoinTable(name = "tb_doctor_availableTime",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id"))
    private List<AvailableTime> agenda;
}
