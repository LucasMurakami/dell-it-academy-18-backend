package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class TrackMapper {

    public static TrackDTO mapToTrackDTOFromTrack(Track track) {
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(track, trackDTO);
        trackDTO.setTrucks( TruckMapper.mapToSetTruckDTO( track.getTrucks() ));
        trackDTO.setCitiesName( CityMapper.mapToListCityNameDTO( track.getCitiesName() ));
        return trackDTO;
    }

    public static Track mapToTrackFromTrackDTO(TrackDTO trackDTO) {
        Track track = new Track();
        BeanUtils.copyProperties(trackDTO, track);
        return track;
    }

}
