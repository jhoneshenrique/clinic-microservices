package com.jhs.patientservice.service.implemen;

import com.jhs.patientservice.dto.PatientRequest;
import com.jhs.patientservice.dto.PatientResponse;
import com.jhs.patientservice.model.Patient;
import com.jhs.patientservice.repository.PatientRepository;
import com.jhs.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImplemen implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void createPatient(PatientRequest patientRequest) {
        patientRepository.save(mapPatientRequestToModel(patientRequest));
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(this::mapModelToPatientResponse).toList();
    }

    @Override
    public PatientResponse getPatientById(long id) {
        return mapModelToPatientResponse(patientRepository.findPatientById(id));
    }

    @Override
    public void updatePatient(PatientResponse patientResponse) {
        patientRepository.save(mapPatientResponseToModel(patientResponse));
    }

    @Override
    public void deletePatient(PatientResponse patientResponse) {
        patientRepository.delete(mapPatientResponseToModel(patientResponse));
    }

    public Patient mapPatientRequestToModel(PatientRequest patientRequest){
        return Patient.builder()
                .familyName(patientRequest.getFamilyName())
                .givenName(patientRequest.getGivenName())
                .birthDate(patientRequest.getBirthDate())
                .phoneNumber(patientRequest.getPhoneNumber())
                .email(patientRequest.getEmail())
                .build();
    }

    public PatientResponse mapModelToPatientResponse(Patient patient){
        return PatientResponse.builder()
                .id(patient.getId())
                .familyName(patient.getFamilyName())
                .givenName(patient.getGivenName())
                .birthDate(patient.getBirthDate())
                .phoneNumber(patient.getPhoneNumber())
                .email(patient.getEmail())
                .build();
    }

    public Patient mapPatientResponseToModel(PatientResponse patientResponse){
        return Patient.builder()
                .id(patientResponse.getId())
                .familyName(patientResponse.getFamilyName())
                .givenName(patientResponse.getGivenName())
                .birthDate(patientResponse.getBirthDate())
                .phoneNumber(patientResponse.getPhoneNumber())
                .email(patientResponse.getEmail())
                .build();
    }
}
