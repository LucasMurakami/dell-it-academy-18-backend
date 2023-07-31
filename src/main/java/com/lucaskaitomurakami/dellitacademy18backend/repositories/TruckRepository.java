package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.Exceptions.ResourceNotFoundException;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface TruckRepository extends JpaRepository<Truck, Long> {

    default Truck findTruckById(Long id) {
        Truck truck = new Truck();

        if (id > 3) {throw new ResourceNotFoundException("Caminhão não existe com esse id: " + id);}

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Trucks.csv"))) {
            String line;
            int counter = 0;

            //skip headers
            br.readLine();

            while (counter < id) {
                line = br.readLine();
                var values = line.split(";");

                truck.setId(Long.valueOf(values[0]));
                truck.setType(values[1]);
                truck.setCanCarry(Integer.valueOf(values[2]));
                truck.setTransportPrice(Double.valueOf(values[3]));

                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return truck;
    }

    default List<Truck> findAllTrucks() {
        List<Truck> trucks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Trucks.csv"))) {
            String line;

            //skip headers
            br.readLine();

            while ((line = br.readLine()) != null) {
                Truck truck = new Truck();
                var values = line.split(";");

                truck.setId(Long.valueOf(values[0]));
                truck.setType(values[1]);
                truck.setCanCarry(Integer.valueOf(values[2]));
                truck.setTransportPrice(Double.valueOf(values[3]));

                trucks.add(truck);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return trucks;
    }

    default Double totalPriceByTrack(Truck truck, int distance) {
        double total = truck.getTransportPrice() * distance;
        return total;
    }
}
