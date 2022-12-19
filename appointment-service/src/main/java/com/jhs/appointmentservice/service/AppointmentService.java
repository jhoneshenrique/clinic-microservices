package com.jhs.appointmentservice.service;

import com.jhs.appointmentservice.dto.AppointmentRequest;

import java.time.LocalTime;

public interface AppointmentService {


    boolean createAppointment(Long doctoId, String appointmentWeekDay, String appointmentWeekTime );
}
