package com.jhs.appointmentservice.controller;


import com.jhs.appointmentservice.dto.AppointmentRequest;
import com.jhs.appointmentservice.service.Implemen.AppointmentImplen;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentImplen appointmentImplen;

    @GetMapping(value = "/{doctorId}/{appointmentWeekDay}/{appointmentTime}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void createAppointment(@PathVariable("doctorId") Long doctorId,
                                  @PathVariable("appointmentWeekDay") String appointmentWeekDay,
                                  @PathVariable("appointmentTime") String appointmentTime){
       boolean available = appointmentImplen.createAppointment(doctorId,appointmentWeekDay,appointmentTime);
        System.out.println("Is doctor available? "+available);
    }
}
