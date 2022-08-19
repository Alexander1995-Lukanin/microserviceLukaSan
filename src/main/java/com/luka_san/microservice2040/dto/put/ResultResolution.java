package com.luka_san.microservice2040.dto.put;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ResultResolution {
    private String eventId;
    private String result;

}
