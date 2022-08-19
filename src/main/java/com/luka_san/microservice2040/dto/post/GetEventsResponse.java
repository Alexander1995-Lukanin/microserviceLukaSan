package com.luka_san.microservice2040.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetEventsResponse {
    @JsonIgnore
   // private String lastEventTime;
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "responseEvents", orphanRemoval = true)
    public Events events;


}
