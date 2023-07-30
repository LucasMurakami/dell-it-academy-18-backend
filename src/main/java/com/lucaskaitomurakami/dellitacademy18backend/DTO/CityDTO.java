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

public class CityDTO {
    private Long id;
    private String name;
    private List<Integer> distances;
}
