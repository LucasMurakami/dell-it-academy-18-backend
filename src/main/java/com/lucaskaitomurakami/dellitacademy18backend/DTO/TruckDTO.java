package com.lucaskaitomurakami.dellitacademy18backend.DTO;

import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckDTO {
    private Long id;
    private String type;
    private Integer canCarry;
    private Double transportPrice;
}
