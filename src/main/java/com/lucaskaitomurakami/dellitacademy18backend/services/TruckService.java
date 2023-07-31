package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;

import java.util.List;

public interface TruckService {

    TruckDTO getTruck(Long id);

    List<TruckDTO> getAllTrucks();
}
