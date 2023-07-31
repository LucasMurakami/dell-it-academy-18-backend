package com.lucaskaitomurakami.dellitacademy18backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvancedTrackDTO {

    private Long id;
    private List<CityNameDTO> citiesName;
    private List<TruckDTO> truckDTOS;
    private List<ProductDTO> productDTOS;
    private Double priceByTrack;
    private Integer trackDistance;
    private Integer totalDistanceTracks;
    private Double totalPriceTracks;
    private Double priceByKM;
    private Double priceByProductType;
    private List<Double> priceByTruckType;
}
