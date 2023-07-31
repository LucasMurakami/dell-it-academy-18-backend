package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.beans.BeanUtils;

import java.util.List;
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

    public static List<Truck> mapToListTruck(List<TruckDTO> truckDTOList){
        return truckDTOList.stream().map( (truckDTO) -> mapToTruck(truckDTO)).collect(Collectors.toList());
    }

    public static List<TruckDTO> mapToListTruckDTO(List<Truck> truckList){
        return truckList.stream().map( (truck) -> mapToTruckDTO(truck)).collect(Collectors.toList());
    }
}
