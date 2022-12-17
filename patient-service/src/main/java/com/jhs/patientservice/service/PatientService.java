package com.jhs.patientservice.service;

import com.jhs.patientservice.dto.PatientRequest;
import com.jhs.patientservice.dto.PatientResponse;

import java.util.List;

public interface PatientService {
    public void createPatient(PatientRequest patientRequest);

    public List<PatientResponse> getAllPatients();

    public PatientResponse getPatientById(long id);
    public void updatePatient(PatientResponse patientResponse);

    public void deletePatient(PatientResponse patientResponse);
}
