package com.homel.interviews.luxsoft.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Parking {
    private List<Place> places = new ArrayList<>();

    public Parking(int size) {
        for (int i = 0; i < size; i++) {
            Place place = new Place();
            place.setId(i);
            places.add(place);
        }
    }

    public Optional<Place> getFreePlace() {
        return places.stream()
                .filter(it -> !it.isBusy())
                .findFirst();
    }

    public void removeCar(Car car) {
        places.stream()
                .filter(place -> place.getCar().getId() == car.getId())
                .forEach(Place::unparkCar);
    }
}
