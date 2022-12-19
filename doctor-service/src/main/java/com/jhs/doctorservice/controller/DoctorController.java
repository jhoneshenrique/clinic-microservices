package com.jhs.doctorservice.controller;


import com.jhs.doctorservice.dto.DoctorRequest;
import com.jhs.doctorservice.dto.DoctorResponse;
import com.jhs.doctorservice.model.AvailableTime;
import com.jhs.doctorservice.service.Implemen.DoctorServiceImplemen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

@Api(value = "Doctor API")
@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {
        private final DoctorServiceImplemen doctorServiceImplemen;

        @ApiOperation(value = "Adds a new Doctor to the system.")
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createDoctor(@RequestBody DoctorRequest doctorRequest){
            doctorServiceImplemen.createDoctor(doctorRequest);
        }

        @ApiOperation(value = "Loads all the Doctors saved on the database.")
        @GetMapping(produces = "application/json")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody ArrayList<DoctorResponse> getAllDoctors(){

                //Adding hypermedia
                Iterable<DoctorResponse> doctorResponseIterable = doctorServiceImplemen.getAllDoctos();
                ArrayList<DoctorResponse> doctorResponseList = new ArrayList<>();
                for(DoctorResponse doctor : doctorResponseIterable){
                        long id = doctor.getId();
                        doctor.add(linkTo(methodOn(DoctorController.class).getDoctorById(id)).withSelfRel());
                        doctorResponseList.add(doctor);
                }

                return doctorResponseList;
        }

        @ApiOperation(value = "Loads a specific doctor saved on the database.")
        @GetMapping(value = "/{id}",produces = "application/json")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody DoctorResponse getDoctorById(@PathVariable(value = "id") long id){
                DoctorResponse doctorResponse = doctorServiceImplemen.getDoctorById(id);
                doctorResponse.add(linkTo(methodOn(DoctorController.class).getDoctorById(id)).withSelfRel());
                return doctorResponse;
        }

        @ApiOperation(value = "Updates the information of a Doctor previously recorded.")
        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public void updateDoctor(@RequestBody DoctorResponse doctorResponse){
                doctorServiceImplemen.updateDoctor(doctorResponse);
        }

        @ApiOperation(value = "Delete an specific Doctor.")
        @DeleteMapping
        @ResponseStatus(HttpStatus.OK)
        public void deleteDoctor(@RequestBody DoctorResponse doctorResponse){
                doctorServiceImplemen.deleteDoctor(doctorResponse);
        }

        @GetMapping(value = "/{id}/{appointmentWeekDay}/{appointmentTime}",produces = "application/json")
        @ResponseStatus(HttpStatus.OK)
        public boolean doctorDisponibility(@PathVariable(value = "id") Long id,
                                           @PathVariable(value = "appointmentWeekDay") String appointmentWeekDay,
                                           @PathVariable(value = "appointmentTime") String appointTime){
                DoctorResponse doctorResponse = doctorServiceImplemen.getDoctorById(id);

                LocalTime appointmentTime = LocalTime.parse(appointTime);

                boolean availableDay = false;
                //Checks if the doctor can attent the appointment that day of the week
                Iterator<AvailableTime> iterator = doctorResponse.getAgenda().iterator();
                while(iterator.hasNext()){
                        String day = iterator.next().getDayOfWeek();
                        if(day.equalsIgnoreCase(String.valueOf(appointmentWeekDay))){
                                availableDay = true;
                        }
                }

                //Checks if the doctor can attent the appointment at that time
                boolean availableTime = false;
                Iterator<AvailableTime> iteratorTime = doctorResponse.getAgenda().iterator();
                while(iteratorTime.hasNext()){
                        LocalTime time = iteratorTime.next().getBeginsAt();
                        if(time.compareTo(appointmentTime)==0){
                                availableTime = true;
                        }
                }

                if(availableDay && availableTime) return true;

                return false;
        }
}
