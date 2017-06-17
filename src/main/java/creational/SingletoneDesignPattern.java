package creational;

/**
 * Created by govind.bhone on 6/6/2017.
 */

/*
Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine. The singleton class must provide a global access point to get the instance of the class. Singleton pattern is used
for logging, drivers objects, caching and thread pool.


*Private constructor to restrict instantiation of the class from other classes.
*Private static variable of the same class that is the only instance of the class.
*Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.

 */

/*
Eager initialization example to avoid concurrancy issue

 */
public class SingletoneDesignPattern {
    private static final SingletoneDesignPattern instance = new SingletoneDesignPattern();

    /*
    private static final SingletoneDesignPattern instance =null ;

    //static block initialization for exception handling
    static{
        try{
            instance = new SingletoneDesignPattern();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

     */

    //private constructor to avoid client applications to use constructor
    private SingletoneDesignPattern() {
    }

    public static SingletoneDesignPattern getInstance() {
        return instance;
    }
}
