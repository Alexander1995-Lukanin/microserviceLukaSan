package com.luka_san.microservice2040.dto.put;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


@RequiredArgsConstructor
@Getter
@Setter
@Validated
public class ResolutionEvents {
    private String eventId;
    private String resolution;
}
