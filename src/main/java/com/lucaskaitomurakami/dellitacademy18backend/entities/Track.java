package com.lucaskaitomurakami.dellitacademy18backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<City> citiesName;

    @OneToMany
    private Set<Truck> trucks = new HashSet<>();

    private Double priceByTrack;
    private Integer trackDistance;

}
