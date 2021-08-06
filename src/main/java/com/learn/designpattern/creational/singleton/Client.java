package com.learn.designpattern.creational.singleton;

public class Client {
    public static void main(String[] args) {
        //Eager initialization
        System.out.println("Eager initialization");
        System.out.println(EagerInitializationSingleton.getInstance());
        System.out.println(EagerInitializationSingleton.getInstance());

        //Static block initialization
        System.out.println("StaticBlock initialization");
        System.out.println(StaticBlockInitializationSingleton.getInstance());
        System.out.println(StaticBlockInitializationSingleton.getInstance());

        //Lazy initialization
        System.out.println("Lazy initialization");
        System.out.println(LazyInitializationSingleton.getInstance());
        System.out.println(LazyInitializationSingleton.getInstance());

        //ThreadSafe Lazy initialization
        System.out.println("ThreadSafe Lazy initialization");
        System.out.println(ThreadSafeLazyInitializationSingleton.getInstance());
        System.out.println(ThreadSafeLazyInitializationSingleton.getInstance());

        //ThreadSafe Double check Lazy initialization
        System.out.println("ThreadSafe Double check Lazy initialization");
        System.out.println(ThreadSafeDoubleCheckLazyInitializationSingleton.getInstance());
        System.out.println(ThreadSafeDoubleCheckLazyInitializationSingleton.getInstance());

        //Bill Pugh Singleton
        System.out.println("Bill Pugh Singleton");
        System.out.println(BillPughSingleton.getInstance());
        System.out.println(BillPughSingleton.getInstance());

        //Enum Singleton
        System.out.println("Enum Singleton");
        System.out.println(EnumSingleton.INSTANCE);
        System.out.println(EnumSingleton.INSTANCE);
    }
}
