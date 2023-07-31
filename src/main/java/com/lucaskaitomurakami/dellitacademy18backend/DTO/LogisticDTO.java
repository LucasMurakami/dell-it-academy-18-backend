package com.lucaskaitomurakami.dellitacademy18backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogisticDTO {

    private Long id;
    private String cityName1;
    private String cityName2;
    private Double totalPriceByTrack;
    private Double priceByKmByTrack;
    private Double averageProductPrice;
    private Double priceByTypeTruck;
    private Long totalTrucks;
    private Long totalProducts;
}
