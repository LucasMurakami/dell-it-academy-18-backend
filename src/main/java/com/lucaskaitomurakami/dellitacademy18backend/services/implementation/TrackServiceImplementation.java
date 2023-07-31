package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.*;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.CityMapper;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.ProductMapper;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TrackMapper;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TruckMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.CityRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.ProductRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TrackRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TruckRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrackServiceImplementation implements TrackService {

    private TrackRepository trackRepository;
    private CityRepository cityRepository;
    private TruckRepository truckRepository;
    private ProductRepository productRepository;


    @Override
    public TrackDTO createTrack(List<CityNameDTO> citiesDTOName, List<TruckDTO> truckDTOSet) {
        List<Truck> truckList = TruckMapper.mapToListTruck(truckDTOSet);
        Track track = trackRepository.createTrack(citiesDTOName.get(0).getName(), citiesDTOName.get(1).getName(), truckList , cityRepository, truckRepository);
        return TrackMapper.mapToTrackDTOFromTrack(track);
    }

    @Override
    public List<AdvancedTrackDTO> createAdvancedTrackDTOList(List<CityNameDTO> citiesDTOName, List<ProductDTO> products) {
        List<String> citiesName = CityMapper.mapToStringListFromCityNameDTO(citiesDTOName);
        List<Product> productList = ProductMapper.mapToListProduct(products);
        List<Track> trackList = trackRepository.createAdvancedTrackList(citiesName, productList, cityRepository, truckRepository, productRepository);
        return TrackMapper.mapToListAdvancedTrackDTOFromTrackList(trackList);
    }

}
