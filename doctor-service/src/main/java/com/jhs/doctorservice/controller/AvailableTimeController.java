package com.jhs.doctorservice.controller;

import com.jhs.doctorservice.dto.AvailableTimeRequest;
import com.jhs.doctorservice.dto.AvailableTimeResponse;
import com.jhs.doctorservice.service.Implemen.AvailableTimeServiceImplemen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Api(value = "Doctor Available Time API")
@RestController
@RequestMapping("/api/availabletime")
@RequiredArgsConstructor
public class AvailableTimeController {
    //Dependency Injection
    private final AvailableTimeServiceImplemen availableTimeServiceImplemen;

    @ApiOperation(value = "Adds a new Available Time to the system.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAvailableTime(@RequestBody AvailableTimeRequest availableTimeRequest){
        availableTimeServiceImplemen.createAvailableTime(availableTimeRequest);
    }

    @ApiOperation(value = "Loads all the Available Time saved on the database.")
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ArrayList<AvailableTimeResponse> getAllAvailableTime(){
        Iterable<AvailableTimeResponse> availableTimeIterable = availableTimeServiceImplemen.getAllAvailableTime();

        //Adding hypermedia
        ArrayList<AvailableTimeResponse> availableTimeList = new ArrayList<AvailableTimeResponse>();
        for (AvailableTimeResponse availableTime: availableTimeIterable) {
            long id = availableTime.getId();
            availableTime.add(linkTo(methodOn(AvailableTimeController.class).loadAvailableTime(id)).withSelfRel());
            availableTimeList.add(availableTime);
        }

        return availableTimeList;
    }

    @ApiOperation(value = "Loads all the Available Time saved on the database.")
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody AvailableTimeResponse loadAvailableTime(@PathVariable(value = "id") long id){
        AvailableTimeResponse availableTimeResponse = availableTimeServiceImplemen.getAvailableTimeById(id);
        availableTimeResponse.add(linkTo(methodOn(AvailableTimeController.class).loadAvailableTime(id)).withRel("Available Time"));
        return availableTimeResponse;
    }

    @ApiOperation(value = "Updates the information of an Available Time previously recorded.")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAvailableTime(@RequestBody AvailableTimeResponse availableTimeResponse){
        availableTimeServiceImplemen.updateAvailableTime(availableTimeResponse);
    }

    @ApiOperation(value = "Delete an specific available time.")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAvailableTime(@RequestBody AvailableTimeResponse availableTimeResponse){
        availableTimeServiceImplemen.deleteAvailableTime(availableTimeResponse);
    }


}
