package com.learn.designpattern.creational.abstract_factory;

public class Client {
    public static void main(String[] args) {
        Vehicle twoWheeler = VehicleFactory.createVehicle(new TwoWheelerFactory());
        Vehicle fourWheeler = VehicleFactory.createVehicle(new FourWheelerFactory());
        twoWheeler.printVehicle();
        fourWheeler.printVehicle();
    }
}
