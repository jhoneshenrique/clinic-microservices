package com.jhs.doctorservice.repository;

import com.jhs.doctorservice.dto.AvailableTimeResponse;
import com.jhs.doctorservice.model.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {
    AvailableTime findById(long id);
}
