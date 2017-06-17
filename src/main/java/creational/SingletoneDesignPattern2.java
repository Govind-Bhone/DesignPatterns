package creational;

import java.lang.reflect.Constructor;

/**
 * Created by govind.bhone on 6/14/2017.
 */

/*
Lazy Evaluation
 */
public class SingletoneDesignPattern2 {

    private static SingletoneDesignPattern2 instance;

    private SingletoneDesignPattern2() {
    }

    public static SingletoneDesignPattern2 getInstance() {
        if (instance == null) {
            instance = new SingletoneDesignPattern2();
        }
        return instance;
    }
}

/*

Thread Safe Pattern
 */

class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;

    }

}

    /*
    Above implementation works fine and provides thread-safety but it reduces the performance
    because of cost associated with the synchronized method, although we need it only for the first few threads
    who might create the separate instances (Read: Java Synchronization). To avoid this extra overhead every time,
    double checked locking principle is used. In this approach, the synchronized block is used inside the if condition with
    an additional check to ensure that only one instance of singleton class is created.
    Below code snippet provides the double checked locking implementation.
     */

class DoubleLocking {

    private static DoubleLocking instance;

    private DoubleLocking() {
    }

    public static DoubleLocking getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLocking();
                }
            }
        }
        return instance;
    }

}


class BillPughSingleton {
    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}


class ReflectionSingletonTest {

    public static void main(String[] args) {
        SingletoneDesignPattern2 instanceOne = SingletoneDesignPattern2.getInstance();
        SingletoneDesignPattern2 instanceTwo = null;
        try {
            Constructor[] constructors = SingletoneDesignPattern2.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (SingletoneDesignPattern2) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}