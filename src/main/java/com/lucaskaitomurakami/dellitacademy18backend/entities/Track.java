package com.lucaskaitomurakami.dellitacademy18backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<City> cities;

    @OneToMany
    private List<Truck> trucks;

    @OneToMany
    private List<Product> products;

    private Double priceByTrack;
    private Integer trackDistance;

    private Integer totalDistanceTracks;
    private Double totalPriceTracks;
    private Double priceByKM;
    private Double priceByProductType;

    @ElementCollection
    private List<Double> priceByTruckType;

}
