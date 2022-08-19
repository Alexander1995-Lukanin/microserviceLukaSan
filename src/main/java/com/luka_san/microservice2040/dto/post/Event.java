package com.luka_san.microservice2040.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Event {

    public  String eventId;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy/")
    public Date eventTime;
    public  String userAcctNumber;
    public  String extAcctNumber;
    // Если придет фильтр с финансами то надо те где есть поле, если нон финансовый, то нужно те, где нет это поле, если амоунт null то выводить все.
    public  Integer amountOriginal;
    public  String amountCurrency;
    public String channel;
    public  String resolution;
    public  String actionAntifraud;
    public  String actionAML;
    public String actionSC;
    public  String eventDetails;
    public String eventDescription;
    public  String dboStatus;
    //@ManyToOne (fetch = FetchType.LAZY)
    //private ResponseEvents responseEvents;
}
