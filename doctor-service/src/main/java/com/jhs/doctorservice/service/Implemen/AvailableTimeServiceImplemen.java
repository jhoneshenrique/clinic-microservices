package com.jhs.doctorservice.service.Implemen;

import com.jhs.doctorservice.dto.AvailableTimeRequest;
import com.jhs.doctorservice.dto.AvailableTimeResponse;
import com.jhs.doctorservice.model.AvailableTime;
import com.jhs.doctorservice.repository.AvailableTimeRepository;
import com.jhs.doctorservice.service.AvailableTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableTimeServiceImplemen implements AvailableTimeService {
    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    @Override
    public void createAvailableTime(AvailableTimeRequest availableTimeRequest){
       AvailableTime availableTime = availableTimeRepository.save(mapAvailableTimeRequestToModel(availableTimeRequest));
    }

    @Override
    public List<AvailableTimeResponse> getAllAvailableTime() {
        List<AvailableTime> availableTimes = availableTimeRepository.findAll();
        return availableTimes.stream().map(this::mapModelToAvailableTimeResponse).toList();
    }

    @Override
    public AvailableTimeResponse getAvailableTimeById(long id) {
        AvailableTime availableTime = availableTimeRepository.findById(id);
        return this.mapModelToAvailableTimeResponse(availableTime);
    }

    @Override
    public void updateAvailableTime(AvailableTimeResponse availableTimeResponse) {
        //Saves the available time.
        availableTimeRepository.save(mapAvailableTimeResponseToModel(availableTimeResponse));
    }

    @Override
    public void deleteAvailableTime(AvailableTimeResponse availableTimeResponse) {
        //Maps the DTO to Model.
        availableTimeRepository.delete(mapAvailableTimeResponseToModel(availableTimeResponse));
    }

    //Creates an AvailableTimeResponse instance to be passed in the stream()
    private AvailableTimeResponse mapModelToAvailableTimeResponse(AvailableTime availableTime){
        return AvailableTimeResponse.builder()
                .id(availableTime.getId())
                .dayOfWeek(availableTime.getDayOfWeek())
                .beginsAt(availableTime.getBeginsAt())
                .endsAt(availableTime.getEndsAt())
                .room(availableTime.getRoom())
                .build();
    }

    private AvailableTime mapAvailableTimeResponseToModel(AvailableTimeResponse availableTimeResponse){
        return AvailableTime.builder()
                .id((availableTimeResponse.getId()))
                .dayOfWeek(availableTimeResponse.getDayOfWeek())
                .beginsAt(availableTimeResponse.getBeginsAt())
                .endsAt(availableTimeResponse.getEndsAt())
                .room(availableTimeResponse.getRoom())
                .build();
    }

    private AvailableTime mapAvailableTimeRequestToModel(AvailableTimeRequest availableTimeRequest){
        return  AvailableTime.builder()
                .dayOfWeek(availableTimeRequest.getDayOfWeek())
                .beginsAt(availableTimeRequest.getBeginsAt())
                .endsAt(availableTimeRequest.getEndsAt())
                .room(availableTimeRequest.getRoom())
                .build();
    }


}


