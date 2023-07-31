package com.lucaskaitomurakami.dellitacademy18backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Logistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName1;

    private String cityName2;

    private Double totalPriceByTrack;

    private Double priceByKmByTrack;

    private Double averageProductPrice;

    private Double priceByTypeTruck;

    private String truckType;

    private Long totalTrucks;

    private Long totalProducts;
}
