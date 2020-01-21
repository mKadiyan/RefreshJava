package com.learn.designpattern.creational.singleton;

public class ThreadSafeDoubleCheckLazyInitializationSingleton {

    private static volatile ThreadSafeDoubleCheckLazyInitializationSingleton instance;

    private ThreadSafeDoubleCheckLazyInitializationSingleton() {
    }

    public static ThreadSafeDoubleCheckLazyInitializationSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeDoubleCheckLazyInitializationSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeDoubleCheckLazyInitializationSingleton();
                }
            }
        }

        return instance;
    }
}
