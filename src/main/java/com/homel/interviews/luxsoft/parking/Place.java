package com.homel.interviews.luxsoft.parking;

public class Place extends Entity {
    private boolean busy;
    private Car car;

    public boolean isBusy() {
        return busy;
    }

    public Car getCar() {
        return car;
    }

    public void parkCar(Car car) {
        this.car = car;
        busy = true;
    }

    public void unparkCar() {
        this.car = null;
        busy = false;
    }
}
