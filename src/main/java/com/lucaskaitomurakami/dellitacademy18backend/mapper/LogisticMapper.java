package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticTrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Logistic;
import org.springframework.beans.BeanUtils;

public class LogisticMapper {

    public static LogisticDTO mapToLogisticDTOfromLogistic(Logistic logistic) {
        LogisticDTO logisticDTO = new LogisticDTO();
        BeanUtils.copyProperties(logistic, logisticDTO);
        return logisticDTO;
    }

    public static Logistic mapToLogisticFromLogisticDTO(LogisticDTO logisticDTO) {
        Logistic logistic = new Logistic();
        BeanUtils.copyProperties(logisticDTO, logistic);
        return logistic;
    }

    public static LogisticTrackDTO mapToLogisticTrackDTOFromLogistic(Logistic logistic) {
        LogisticTrackDTO logisticTrackDTO = new LogisticTrackDTO();
        logisticTrackDTO.setCityName1(logistic.getCityName1());
        logisticTrackDTO.setCityName2(logistic.getCityName2());
        logisticTrackDTO.setTruckId(logistic.getTruckId());
        logisticTrackDTO.setTruckType(logistic.getTruckType());
        logisticTrackDTO.setTrackDistance(logistic.getTrackDistance());
        logisticTrackDTO.setPriceByTrack(logistic.getPriceByTrack());
        return logisticTrackDTO;
    }
}
