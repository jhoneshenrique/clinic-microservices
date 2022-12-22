package com.jhs.appointmentservice.service.Implemen;

import com.jhs.appointmentservice.dto.AppointmentRequest;
import com.jhs.appointmentservice.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;


@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentImplen implements AppointmentService {

    //Dependency Injection
    private final WebClient.Builder webClientBuilder;



    @Override
    public boolean createAppointment(Long doctoId, String appointmentWeekDay, String appointmentWeekTime) {

        //Call doctor to see if the day is available
        boolean result = webClientBuilder.build().get()
                .uri("http://doctor-service/api/doctor/"+doctoId+"/"+appointmentWeekDay+"/"+appointmentWeekTime)
                .retrieve()
                .bodyToMono(Boolean.class) //retrieve the body of the info. The Boolean.class is because the method returns a boolean
                .block(); //That tell us is a syncronous call.

        return result;
    }
}
