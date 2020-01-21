package com.learn.designpattern.creational.abstract_factory;

public class VehicleFactory {
    static Vehicle createVehicle(VehicleAbstractFactory vehicleAbstractFactory){
        return vehicleAbstractFactory.createVehicle();
    }
}
