package creational;

import java.io.Serializable;

/**
 * Created by govind.bhone on 6/16/2017.
 */

enum SingletoneEnum {
    INSTANCE;


    public static void doSomething() {
        System.out.println("calling singletone execution ");
    }
}

public class SingletoneDesignPattern3 {
    public static void main(String args[]) {
        SingletoneEnum e = SingletoneEnum.INSTANCE;
        e.doSomething();
    }
}




