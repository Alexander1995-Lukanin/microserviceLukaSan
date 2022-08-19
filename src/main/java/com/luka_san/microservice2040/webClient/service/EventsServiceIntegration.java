package com.luka_san.microservice2040.webClient.service;

import com.luka_san.microservice2040.dto.post.ReqwestEvents;
import com.luka_san.microservice2040.dto.post.Root;
import com.luka_san.microservice2040.dto.put.ResolutionEvents;
import com.luka_san.microservice2040.dto.put.ResultResolution;

public interface EventsServiceIntegration {

    ResultResolution resolutionEventsIntegration(ResolutionEvents resolutionEvents);
    Root responseEventsIntegration(ReqwestEvents reqwestEvents);
}

