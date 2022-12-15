package com.jhs.doctorservice.service.Implemen;

import com.jhs.doctorservice.dto.DoctorRequest;
import com.jhs.doctorservice.dto.DoctorResponse;
import com.jhs.doctorservice.model.Doctor;
import com.jhs.doctorservice.repository.DoctorRepository;
import com.jhs.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImplemen implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void createDoctor(DoctorRequest doctorRequest) {
        doctorRepository.save(mapDoctorRequestToModel(doctorRequest));
    }

    @Override
    public List<DoctorResponse> getAllDoctos() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(this::mapModelToDoctorResponse).toList();
    }

    @Override
    public DoctorResponse getDoctorById(long id) {
        Doctor doctor = doctorRepository.findById(id);
        return mapModelToDoctorResponse(doctor);
    }

    @Override
    public void updateDoctor(DoctorResponse doctorResponse) {
        doctorRepository.save(mapDoctorResponseToModel(doctorResponse));
    }

    @Override
    public void deleteDoctor(DoctorResponse doctorResponse) {
        doctorRepository.delete(mapDoctorResponseToModel(doctorResponse));
    }

    private Doctor mapDoctorRequestToModel(DoctorRequest doctorRequest){
        return Doctor.builder()
                .familyName(doctorRequest.getFamilyName())
                .givenName(doctorRequest.getGivenName())
                .birthDate(doctorRequest.getBirthDate())
                .specialty(doctorRequest.getSpecialty())
                .agenda(doctorRequest.getAgenda())
                .build();
    }

    private DoctorResponse mapModelToDoctorResponse(Doctor doctor){
        return DoctorResponse.builder()
                .id(doctor.getId())
                .familyName(doctor.getFamilyName())
                .givenName(doctor.getGivenName())
                .birthDate(doctor.getBirthDate())
                .specialty(doctor.getSpecialty())
                .agenda(doctor.getAgenda())
                .build();
    }

    private Doctor mapDoctorResponseToModel(DoctorResponse doctorResponse){
        return Doctor.builder()
                .id(doctorResponse.getId())
                .familyName(doctorResponse.getFamilyName())
                .givenName(doctorResponse.getGivenName())
                .birthDate(doctorResponse.getBirthDate())
                .specialty(doctorResponse.getSpecialty())
                .agenda(doctorResponse.getAgenda())
                .build();
    }
}
