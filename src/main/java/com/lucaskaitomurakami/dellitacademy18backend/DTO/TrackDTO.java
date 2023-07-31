package com.lucaskaitomurakami.dellitacademy18backend.DTO;

import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {

    private Long id;
    private String cityName1;
    private String cityName2;
    private Double priceByTrack;
    private Integer trackDistance;
    private Set<Truck> trucks = new HashSet<>();
}
