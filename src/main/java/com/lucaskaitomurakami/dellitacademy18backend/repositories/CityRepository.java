package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.Exceptions.InvalidInputException;
import com.lucaskaitomurakami.dellitacademy18backend.Exceptions.ResourceNotFoundException;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    default City findCityById(Long id) {
        City city = new City();

        if (id > 24) {throw new ResourceNotFoundException("Cidade não existe com esse id: " + id);}

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/DNIT-Distancias.csv"))) {
            String line;
            String[] header;
            int counter = 0;

            line = br.readLine();
            header = line.split(";");
            while (counter < id) {
                line = br.readLine();

                var values = line.split(";");
                List<Integer> valuesInt = new ArrayList<>();

                for (String value : values) {valuesInt.add(Integer.parseInt(value));}

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

    default List<City> findAllCities() {
        List<City> cities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/DNIT-Distancias.csv"))) {
            String line;
            String[] header;
            int counter = 0;

            line = br.readLine();
            header = line.split(";");
            while ((line = br.readLine()) != null) {
                City city = new City();
                var values = line.split(";");
                List<Integer> valuesInt = new ArrayList<>();

                for (String value : values) {valuesInt.add(Integer.parseInt(value));}

                city.setName(header[counter]);
                counter++;
                city.setDistances(valuesInt);
                city.setId((long) counter);

                cities.add(city);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    default City findCityByName(String cityName) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/DNIT-Distancias.csv"))) {
            String line;
            String[] header;
            int counter = 0;

            line = br.readLine();
            header = line.split(";");

            for (String name: header) {
                counter++;
                if(cityName.toUpperCase().equals(name)) {return findCityById((long) counter);}
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new ResourceNotFoundException("Cidade não existe com esse nome: " + cityName);
    }

    default Integer findDistanceBetweenCities(City city1, City city2) {

        if(city1.getName().equals(city2.getName()) ){
            throw new InvalidInputException("Cidade de origem com mesmo destino da cidade de destino: " + city1.getName() + " e " + city2.getName());
        }
        int distance = city1.getDistances().get(Math.toIntExact(city2.getId() -1));
        return distance;
    }

    default List<City> originAndDestinationCities(String cityName1, String cityName2) {
        City city1, city2;
        List<City> citiesName = new ArrayList<>();
        city1 = findCityByName(cityName1);
        city2 = findCityByName(cityName2);
        citiesName.add(city1);
        citiesName.add(city2);
        return citiesName;
    }

}
