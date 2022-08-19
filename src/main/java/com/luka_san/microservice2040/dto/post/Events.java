package com.luka_san.microservice2040.dto.post;

import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    public ArrayList<Event> event;
}
