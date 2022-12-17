package com.jhs.patientservice.controller;

import com.jhs.patientservice.dto.PatientRequest;
import com.jhs.patientservice.dto.PatientResponse;
import com.jhs.patientservice.service.implemen.PatientServiceImplemen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientServiceImplemen patientServiceImplemen;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@RequestBody  PatientRequest patientRequest){
        patientServiceImplemen.createPatient(patientRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<PatientResponse> getAllPatients(){
        return patientServiceImplemen.getAllPatients();
    }

}
