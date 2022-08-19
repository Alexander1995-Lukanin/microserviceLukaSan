package com.luka_san.microservice2040.dto.post;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.luka_san.microservice2040.dto.enumDTO.ActionAntifraud;
import com.luka_san.microservice2040.dto.enumDTO.OperationType;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqwestEvents {

    private OperationType operationType;
    //обработать null на необязательных полях
    // другой тип //джексон
    private Date dateFrom;
    private Date dateTo;
    private ActionAntifraud actionAntifraud;
    // По аналогии с датами через форейч и ифы.
    private Integer minAmount;
    private Integer maxAmount;
    private Integer rowsCount;
}
