package com.jhs.doctorservice.repository;

import com.jhs.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findById(long id);
}
