package com.jhs.doctorservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Entity
@Table(name = "tb_availableTime")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String dayOfWeek;
    @NotBlank
    private LocalTime beginsAt;
    @NotBlank
    private LocalTime endsAt;
    @NotBlank
    private String room;
}
