package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static Set<Truck> mapToSetTruck(Set<TruckDTO> truckDTOSet){
        return truckDTOSet.stream().map( (truckDTO) -> mapToTruck(truckDTO)).collect(Collectors.toSet());
    }

    public static Set<TruckDTO> mapToSetTruckDTO(Set<Truck> truckSet){
        return truckSet.stream().map( (truck) -> mapToTruckDTO(truck)).collect(Collectors.toSet());
    }
}
