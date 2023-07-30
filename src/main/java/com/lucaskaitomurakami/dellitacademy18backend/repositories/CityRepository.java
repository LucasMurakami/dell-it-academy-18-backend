package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.Exceptions.ResourceNotFoundException;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CityRepository {

    public City findCityById(Long id) {
        City city = new City();

        if (id > 24) {
            throw new ResourceNotFoundException("Cidade não existe com esse id: " + id);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/DNIT-Distancias.csv"))) {
            String line;
            String[] header;
            int counter = 0;

            line = br.readLine();
            header = line.split(";");
            while (counter < id) {
                line = br.readLine();
                String[] values = line.split(";");
                List<Integer> valuesInt = new ArrayList<>();

                for (String value : values) {
                    valuesInt.add(Integer.parseInt(value));
                }

                city.setName(header[counter]);
                city.setDistances(valuesInt);
                city.setId(id);

                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return city;
    }

}
