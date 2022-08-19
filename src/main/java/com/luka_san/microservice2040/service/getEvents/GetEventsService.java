package com.luka_san.microservice2040.service.getEvents;

import com.luka_san.microservice2040.dto.post.ReqwestEvents;
import com.luka_san.microservice2040.dto.post.Root;
import com.luka_san.microservice2040.exception.UserIncorrectDataEntryException;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface GetEventsService {
   Root resultEvents(ReqwestEvents reqwestEvents) throws UserIncorrectDataEntryException, MethodArgumentNotValidException;
}

