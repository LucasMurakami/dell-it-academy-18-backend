package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TruckMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TruckRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TruckServiceImplementation implements TruckService {

    private TruckRepository truckRepository;

    @Override
    @Transactional(readOnly = true)
    public TruckDTO getTruck(Long id) {
        Truck truck = truckRepository.findTruckById(id);
        return TruckMapper.mapToTruckDTO(truck);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TruckDTO> getAllTrucks() {
        List<TruckDTO> trucks = truckRepository.findAllTrucks().stream().map((truck) -> TruckMapper.mapToTruckDTO(truck)).toList();
        return trucks;
    }
}
