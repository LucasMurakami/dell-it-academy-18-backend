package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.AdvancedTrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class TrackMapper {

    public static TrackDTO mapToTrackDTOFromTrack(Track track) {
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(track, trackDTO);
        trackDTO.setTrucks( TruckMapper.mapToListTruckDTO( track.getTrucks()) );
        trackDTO.setCitiesName( CityMapper.mapToListCityNameDTO( track.getCities()) );
        return trackDTO;
    }

    public static Track mapToTrackFromTrackDTO(TrackDTO trackDTO) {
        Track track = new Track();
        BeanUtils.copyProperties(trackDTO, track);
        return track;
    }

    public static AdvancedTrackDTO mapToAdvancedTrackDTOFromTrack(Track track) {
        AdvancedTrackDTO advancedTrackDTO = new AdvancedTrackDTO();
        BeanUtils.copyProperties(track, advancedTrackDTO);
        advancedTrackDTO.setCitiesName( CityMapper.mapToListCityNameDTO(track.getCities()) );
        advancedTrackDTO.setTruckDTOS( TruckMapper.mapToListTruckDTO(track.getTrucks()) );
        advancedTrackDTO.setProductDTOS( ProductMapper.mapToListProductDTO(track.getProducts()) );
        return advancedTrackDTO;
    }

    public static List<AdvancedTrackDTO> mapToListAdvancedTrackDTOFromTrackList(List<Track> trackList) {
        return trackList.stream().map( (track) -> mapToAdvancedTrackDTOFromTrack(track)).toList();
    }

}
