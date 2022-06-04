package com.homel.interviews.luxsoft.parking;

import java.util.Optional;

public class ParkingServiceImpl implements ParkingService {

    private Parking parking = new Parking(10);

    @Override
    public boolean park(Car car) {
        Optional<Place> freePlaces = parking.getFreePlace();

        if (freePlaces.isPresent()) {
            Place place1 = freePlaces.get();
            place1.parkCar(car);
            return true;
        }
        return false;
    }

    @Override
    public void unpark(Car car) {
        parking.removeCar(car);
    }
}
