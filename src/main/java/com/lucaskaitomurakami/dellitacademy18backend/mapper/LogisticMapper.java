package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticConsultDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Logistic;
import org.springframework.beans.BeanUtils;

public class LogisticMapper {

    public static LogisticDTO mapToLogisticDTO(Logistic logistic) {
        LogisticDTO logisticDTO = new LogisticDTO();
        BeanUtils.copyProperties(logistic, logisticDTO);
        return logisticDTO;
    }

    public static Logistic mapToLogistic(LogisticDTO logisticDTO) {
        Logistic logistic = new Logistic();
        BeanUtils.copyProperties(logisticDTO, logistic);
        return logistic;
    }

    // NOT INCLUDED TRUCK TYPE
    public static LogisticConsultDTO LogisticConsultDTO(Logistic logistic) {
        LogisticConsultDTO logisticConsultDTO = new LogisticConsultDTO();
        logisticConsultDTO.setCityName1(logistic.getCityName1());
        logisticConsultDTO.setCityName2(logistic.getCityName2());
        return logisticConsultDTO;
    }
}
