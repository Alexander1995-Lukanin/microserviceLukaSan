package com.luka_san.microservice2040.service.activityEngine;

import com.luka_san.microservice2040.dto.put.ResolutionEvents;
import com.luka_san.microservice2040.dto.put.ResultResolution;
import com.luka_san.microservice2040.exception.UserIncorrectDataEntryException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface ActivityEngineService {

    List<ResultResolution> resultResolution(List<ResolutionEvents> resolutionEvents) throws UserIncorrectDataEntryException, MethodArgumentNotValidException;

}

