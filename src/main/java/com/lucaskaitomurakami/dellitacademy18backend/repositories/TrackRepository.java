package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    default Track createTrack(String cityName1, String cityName2, List<Truck> trucks, CityRepository cityRepository, TruckRepository truckRepository) {
        Track track = new Track();

        List<City> cities = cityRepository.originAndDestinationCities(cityName1, cityName2);
        int distance = cityRepository.findDistanceBetweenCities(cities.get(0), cities.get(1));
        List<Double> priceByTruckType = priceByTruckType(trucks, truckRepository, distance);

        track.setTrucks(trucks);
        track.setPriceByTrack(truckRepository.totalPriceByTrackAllTrucks(trucks, distance));
        track.setPriceByTruckType(priceByTruckType);
        track.setCities(cities);
        track.setTrackDistance(distance);

        return track;
    }

    default Track createAdvancedTrack(String cityName1, String cityName2, List<Truck> trucks,List<Product> products,
                                      CityRepository cityRepository, TruckRepository truckRepository) {
        Track track = createTrack(cityName1, cityName2, trucks, cityRepository, truckRepository);
        track.setProducts(products);
        return track;
    }

    default List<Track> createAdvancedTrackList(List<String> citiesName, List<Product> products,
                                                CityRepository cityRepository, TruckRepository truckRepository, ProductRepository productRepository) {
        List<Track> tracks = new ArrayList<>();

        int index = 0;
        int totalDistanceTracks = 0;
        double totalPriceTracks = 0;
        double productsWeigth = 0;

        for (Product product: products) {productsWeigth += productRepository.totalWeigth(product);}

        List<Truck> trucks = truckRepository.findBestTruckPrice(productsWeigth, truckRepository);

        for (int i = 1; i < citiesName.size(); i++) {
            Track track = createAdvancedTrack(citiesName.get(index), citiesName.get(i), trucks, products, cityRepository, truckRepository);
            tracks.add(track);
            totalDistanceTracks += track.getTrackDistance();
            totalPriceTracks += track.getPriceByTrack();
            index++;
        }

        for (Track track:tracks) {
            track.setTotalDistanceTracks(totalDistanceTracks);
            track.setTotalPriceTracks((totalPriceTracks));
            track.setPriceByKM(priceByKm(totalPriceTracks, track.getTrackDistance()));
            track.setPriceByProductType(priceByProductType(totalPriceTracks, products.size()));
        }

        return tracks;
    }

    default Double priceByKm(double totalPriceTracks, int distance) {
        return round((totalPriceTracks / distance), 2);
    }

    default Double priceByProductType(double totalPriceTracks, int size) {
        return round((totalPriceTracks/size), 2);
    }

    default List<Double> priceByTruckType(List<Truck> trucks, TruckRepository truckRepository, Integer distance) {
        double priceBySmallTruck = 0, priceByMediumTruck = 0, priceByLargeTruck = 0, priceByTrack = 0;

        for (Truck t: trucks) {
            priceByTrack += truckRepository.totalPriceByTrack(t, distance);
            switch (t.getType()) {
                case "P" -> priceBySmallTruck += priceByTrack;
                case "M" -> priceByMediumTruck += priceByTrack;
                case "G" -> priceByLargeTruck += priceByTrack;
            }
        }

        List<Double> priceByTruckType = new ArrayList<>();
        priceByTruckType.add(round(priceBySmallTruck, 2));
        priceByTruckType.add(round(priceByMediumTruck, 2));
        priceByTruckType.add(round(priceByLargeTruck, 2));
        return priceByTruckType;
    }

    static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
