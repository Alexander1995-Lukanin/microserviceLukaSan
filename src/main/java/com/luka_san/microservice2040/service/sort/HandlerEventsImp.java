package com.luka_san.microservice2040.service.sort;

import com.luka_san.microservice2040.dto.post.Event;
import com.luka_san.microservice2040.dto.post.Events;
import com.luka_san.microservice2040.dto.post.ReqwestEvents;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
public class HandlerEventsImp implements HandlerEvents {
        private List <Event> eventList;
        private final ReqwestEvents reqwestEvents;



    public HandlerEventsImp eventsHandlerMaskCard(HandlerEventsImp events) {
        for (Event event : events.eventList) {
            if (event.getUserAcctNumber() != null) {
                event.setUserAcctNumber(replaceCardNumber(event.getUserAcctNumber()));
            }
            if (event.getExtAcctNumber() != null) {
                event.setUserAcctNumber(replaceCardNumber(event.getExtAcctNumber()));
            }
        }
        return this;
    }

    public String replaceCardNumber(String text) {
        final String MASKCARD = "$1<MASKED>$2";
        final Pattern PATTERNCARD =
                Pattern.compile("\\b([0-9]{4})[0-9]{0,9}([0-9]{4})\\b");
        Matcher matcher = PATTERNCARD.matcher(text);
        if (matcher.find()) {
            return matcher.replaceAll(MASKCARD);
        }
        return text;
    }

    //затестить сделать через форейч
    // обязательные и необязательные
    // фильтрация вместо сортировки. Отсекаем по дате.
    // Дата со временем ПОМЕНЯТЬ
    @Override
    public HandlerEventsImp eventsFilterTime(HandlerEventsImp events) {
        List<Event> eventList = new ArrayList<>();
        for (Event event : events.eventList) {
            if (reqwestEvents.getDateFrom() != null && reqwestEvents.getDateTo() != null) {
                //EventTime 15.08.2022 - DateFrom 12.08.2022 // либо оба ограничителя либо их нету обоих
                //Типы с датами и как их сравнивать - также DateTo
                if (event.getEventTime().after(reqwestEvents.getDateFrom()) && event.getEventTime().before(reqwestEvents.getDateTo())) {
                    eventList.add(event);
                }
            }
        }
        events.eventList.clear();
        events.eventList.addAll(eventList);
        return this;
    }
    // Екшен Антифрод добавить.
    // Все финансовые и все не финансовые операции из оставшихся 100 ивентов смотрим есть поле амаунт финансовое.
    @Override
    public HandlerEventsImp eventsFilterOperationType(HandlerEventsImp events) {
        List<Event> eventList = new ArrayList<>();
        switch (reqwestEvents.getOperationType()) {
            case FINANCIAL:
                for (Event event : events.eventList) {
                    if (event.getAmountOriginal() != null)
                        eventList.add(event);
                }
                break;
            case ALL:
                return this;
            case NON_FINANCIAL:
                for (Event event : events.eventList) {
                    if (event.getAmountOriginal() == null)
                        eventList.add(event);
                }
                break;
        }
        events.eventList.clear();
        events.eventList.addAll(eventList);
        return this;
    }


    // макс и мин ( от 100 и 200 ) если в диапозоне то выдергиваем.
    @Override
    public HandlerEventsImp eventsFilterAmountOriginal(HandlerEventsImp events) {
        List<Event> eventList = new ArrayList<>();
        for (Event event : events.eventList) {
            if (reqwestEvents.getMaxAmount() != null && reqwestEvents.getMinAmount() != null) {
                //EventTime 15.08.2022 - DateFrom 12.08.2022 // либо оба ограничителя либо их нету обоих
                //Типы с датами и как их сравнивать - также DateTo
                if (event.getAmountOriginal() >= reqwestEvents.getMinAmount() && event.getAmountOriginal() <= reqwestEvents.getMaxAmount()) {
                    eventList.add(event);
                }
            }
        }
        events.eventList.clear();
        events.eventList.addAll(eventList);
        return this;

    }

    @Override
    public HandlerEventsImp eventsFilterRowsCount(HandlerEventsImp events) {
        List<Event> eventList = new ArrayList<>();
        for (Event event : events.eventList) {
            do {
                eventList.add(event);
            }
            while (eventList.size() == reqwestEvents.getRowsCount());
        }
        events.eventList.clear();
        events.eventList.addAll(eventList);
        return this;
    }

    @Override
    public HandlerEventsImp eventsFilterActionAntifraud(HandlerEventsImp events) {
        List<Event> eventList = new ArrayList<>();
        switch (reqwestEvents.getActionAntifraud()) {
            case ALL:
                return this;
            case ALLOW:
                for (Event event : events.eventList) {
                    if (event.getActionAntifraud().equals("ALLOW"))
                        eventList.add(event);
                }
                break;
            case CHALLENGE:
                for (Event event : events.eventList) {
                    if (event.getActionAntifraud().equals("CHALLENGE"))
                        eventList.add(event);
                }
                break;
            case DENY:
                for (Event event : events.eventList) {
                    if (event.getActionAntifraud().equals("DENY"))
                        eventList.add(event);
                }
                break;
            case REVIEW:
                for (Event event : events.eventList) {
                    if (event.getActionAntifraud().equals("REVIEW"))
                        eventList.add(event);
                }
                break;

        }
        events.eventList.clear();
        events.eventList.addAll(eventList);
        return this;
    }

    @Override
    public HandlerEventsImp eventsSortTime(HandlerEventsImp events) {
        events.eventList.stream().map(Event::getEventTime).sorted();
        return this;
    }

    public List<Event> eventsFilterMax(HandlerEventsImp events) {
                 events.eventsFilterTime(events)
                .eventsFilterActionAntifraud(events)
                .eventsFilterOperationType(events)
                .eventsFilterAmountOriginal(events)
                .eventsFilterRowsCount(events)
                .eventsSortTime(events);
             //   .eventsHandlerMaskCard(events);


        // Добавить сортировку по дате в обратом порядке по ивент тайм.
        return events.eventList;
     }

}
