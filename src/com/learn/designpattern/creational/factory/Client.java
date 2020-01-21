package com.learn.designpattern.creational.factory;

import static com.learn.designpattern.creational.factory.Type.FOUR_WHEELER;
import static com.learn.designpattern.creational.factory.Type.TWO_WHEELER;

class Client {
    public static void main(String[] args) {
        Vehicle twoWheeler = VehicleFactory.createVehicle(TWO_WHEELER);
        Vehicle fourWheeler = VehicleFactory.createVehicle(FOUR_WHEELER);
        twoWheeler.printVehicle();
        fourWheeler.printVehicle();
    }
}
