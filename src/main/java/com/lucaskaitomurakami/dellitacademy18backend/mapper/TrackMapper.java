package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import org.springframework.beans.BeanUtils;

public class TrackMapper {

    public static TrackDTO mapToLogisticDTOfromLogistic(Track track) {
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(track, trackDTO);
        return trackDTO;
    }

    public static Track mapToLogisticFromLogisticDTO(TrackDTO trackDTO) {
        Track track = new Track();
        BeanUtils.copyProperties(trackDTO, track);
        return track;
    }

}
