package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.beans.BeanUtils;

public class TruckMapper {

    public static TruckDTO mapToTruckDTO(Truck truck) {
        TruckDTO truckDTO = new TruckDTO();
        BeanUtils.copyProperties(truck, truckDTO);
        return truckDTO;
    }

    public static Truck mapToTruck(TruckDTO truckDTO) {
        Truck truck = new Truck();
        BeanUtils.copyProperties(truckDTO, truck);
        return truck;
    }
}
