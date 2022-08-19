package com.luka_san.microservice2040.webClient.service;

import com.luka_san.microservice2040.dto.post.ReqwestEvents;
import com.luka_san.microservice2040.dto.post.Root;
import com.luka_san.microservice2040.dto.put.ResolutionEvents;
import com.luka_san.microservice2040.dto.put.ResultResolution;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class EventsServiceIntegrationImpl implements EventsServiceIntegration {
    private final WebClient webClient;


    public  ResultResolution resolutionEventsIntegration(ResolutionEvents resolutionEventsInt) {
        ResultResolution response = webClient.put()
                .uri("/getEvents")
                .body(Mono.just(resolutionEventsInt), ResolutionEvents.class)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(ResultResolution.class)
                .block();
        return response;
    }

//    public ResponseEvents  getUserBySync (ReqwestEvents reqwestEvents) {
//        ResponseEvents response = webClient
//                .get()
//                .uri(String.join("", "/getEvents/"))
//                .headers(HttpHeaders::size)
//                .retrieve()
//                .bodyToMono(ResponseEvents.class)
//                .block();
//        return response;

   // }

    @Override
    public Root responseEventsIntegration(ReqwestEvents reqwestEvents) {
                Root root = webClient.get()
                .uri("/getEvents")
                .header("mdmIid","3")
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(Root.class)
                .block();
        return  root;

    }

}

