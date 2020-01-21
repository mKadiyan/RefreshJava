package com.learn.designpattern.creational.singleton;

public class StaticBlockInitializationSingleton {

    private static StaticBlockInitializationSingleton instance;

    static {
        try {
            instance = new StaticBlockInitializationSingleton();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    private StaticBlockInitializationSingleton() {
    }

    public static StaticBlockInitializationSingleton getInstance() {
        return instance;
    }
}
