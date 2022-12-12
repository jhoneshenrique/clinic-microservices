package com.jhs.doctorservice.service;

import com.jhs.doctorservice.dto.AvailableTimeRequest;
import com.jhs.doctorservice.dto.AvailableTimeResponse;

import java.util.List;

public interface AvailableTimeService {
    public void createAvailableTime(AvailableTimeRequest availableTimeRequest);

    public List<AvailableTimeResponse> getAllAvailableTime();

    public AvailableTimeResponse getAvailableTimeById(long id);

    public void updateAvailableTime(AvailableTimeResponse availableTimeResponse);

    public void deleteAvailableTime(AvailableTimeResponse availableTimeResponse);
}
