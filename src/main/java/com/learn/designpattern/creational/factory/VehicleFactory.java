package com.learn.designpattern.creational.factory;

class VehicleFactory {
    static final Vehicle createVehicle(Type type) {
        Vehicle vehicle = null;
        switch (type) {
            case TWO_WHEELER:
                vehicle = new TwoWheeler();
                break;
            case FOUR_WHEELER:
                vehicle = new FourWheeler();
                break;
            default:
                vehicle = null;
        }

        return vehicle;
    }
}
