package com.luka_san.microservice2040.service.getEvents;

import com.luka_san.microservice2040.dto.post.Events;
import com.luka_san.microservice2040.dto.post.ReqwestEvents;
import com.luka_san.microservice2040.dto.post.Root;
import com.luka_san.microservice2040.exception.UserIncorrectDataEntryException;
import com.luka_san.microservice2040.service.sort.HandlerEventsImp;
import com.luka_san.microservice2040.webClient.service.EventsServiceIntegrationImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetEventsServiceImpl implements GetEventsService {
    private final EventsServiceIntegrationImpl eventsServiceIntegration;

    //Post
    @Override
    public Root resultEvents(ReqwestEvents reqwestEvents) throws UserIncorrectDataEntryException {
        Root root;
     //  do {
          root = eventsServiceIntegration.responseEventsIntegration(reqwestEvents);
   //    }
     //   while (getEventsResponse.getLastEventTime() != null && reqwestEvents.getDateFrom().equals(getEventsResponse.getLastEventTime()));


        HandlerEventsImp handlerEventsImp = new HandlerEventsImp(root.getEventsResponse.getEvents().event, reqwestEvents);
        handlerEventsImp.eventsFilterMax(handlerEventsImp);
        return root;
    }

}
