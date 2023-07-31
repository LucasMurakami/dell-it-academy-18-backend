package com.lucaskaitomurakami.dellitacademy18backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {

    private Long id;
    private String cityName1;
    private String cityName2;
    private String truckId;
    private String truckType;
    private Double priceByTrack;
    private Integer trackDistance;
}
