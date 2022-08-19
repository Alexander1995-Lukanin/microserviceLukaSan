package com.luka_san.microservice2040.service.sort;

import com.luka_san.microservice2040.dto.post.Event;

import java.util.List;

public interface HandlerEvents {
    HandlerEventsImp eventsHandlerMaskCard(HandlerEventsImp events);

    String replaceCardNumber(String text);

    HandlerEventsImp eventsFilterTime(HandlerEventsImp events);

    HandlerEventsImp eventsFilterOperationType(HandlerEventsImp events);

    HandlerEventsImp eventsFilterAmountOriginal(HandlerEventsImp events);

    HandlerEventsImp eventsFilterRowsCount(HandlerEventsImp events);

    HandlerEventsImp eventsFilterActionAntifraud(HandlerEventsImp events);

    HandlerEventsImp eventsSortTime (HandlerEventsImp events);

    List<Event> eventsFilterMax(HandlerEventsImp events);
}
