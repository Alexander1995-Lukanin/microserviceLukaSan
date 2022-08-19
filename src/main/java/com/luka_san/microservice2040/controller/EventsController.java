package com.luka_san.microservice2040.controller;


import com.luka_san.microservice2040.dto.post.ReqwestEvents;
import com.luka_san.microservice2040.dto.post.GetEventsResponse;
import com.luka_san.microservice2040.dto.post.Root;
import com.luka_san.microservice2040.dto.put.ResolutionEvents;
import com.luka_san.microservice2040.dto.put.ResultResolution;
import com.luka_san.microservice2040.service.activityEngine.ActivityEngineServiceImpl;
import com.luka_san.microservice2040.service.getEvents.GetEventsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
public class EventsController {
   private final ActivityEngineServiceImpl activityEngineService;
   private final GetEventsServiceImpl getEventsService;

    @PutMapping("/events")
    public List<ResultResolution> eventsResult (@Valid @NotNull @RequestBody List <ResolutionEvents>  resolutionEvents) throws MethodArgumentNotValidException {
        return  activityEngineService.resultResolution(resolutionEvents);
    }


    @PostMapping("/events")
    public Root responseEventsDateFrom  (@RequestHeader("mdmIid") String language, @RequestBody ReqwestEvents reqwestEvents)  throws MethodArgumentNotValidException {
        return getEventsService.resultEvents(reqwestEvents);
    }
   }
