package com.jhs.doctorservice.service;

import com.jhs.doctorservice.dto.DoctorRequest;
import com.jhs.doctorservice.dto.DoctorResponse;


import java.util.List;


public interface DoctorService {
    public void createDoctor(DoctorRequest doctorRequest);

    public List<DoctorResponse> getAllDoctos();

    public DoctorResponse getDoctorById(long id);
    public void updateDoctor(DoctorResponse doctorResponse);

    public void deleteDoctor(DoctorResponse doctorResponse);

}
