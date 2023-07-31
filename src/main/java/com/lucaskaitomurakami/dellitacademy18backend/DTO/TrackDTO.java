package com.lucaskaitomurakami.dellitacademy18backend.DTO;

import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {

    private Long id;
    private List<CityNameDTO> citiesName = new ArrayList<>();
    private List<TruckDTO> trucks = new ArrayList<>();
    private Double priceByTrack;
    private Integer trackDistance;

}
