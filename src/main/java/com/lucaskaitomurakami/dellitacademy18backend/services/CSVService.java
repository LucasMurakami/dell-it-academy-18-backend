package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    public CityDTO getCityById (Long id) throws FileNotFoundException {
        CityDTO cityDTO = new CityDTO();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/DNIT-Distancias.csv"))) {
            String line;
            String [] header;
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

                cityDTO.setName(header[counter]);
                cityDTO.setDistances(valuesInt);
                cityDTO.setId(id);

                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cityDTO;
    }

}
