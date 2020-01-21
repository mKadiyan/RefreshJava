package com.learn.designpattern.creational.abstract_factory;

public class TwoWheelerFactory implements VehicleAbstractFactory {

    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}
