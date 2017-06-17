package creational;

import java.io.*;

/**
 * Created by govind.bhone on 6/16/2017.
 */

/*
The serialization runtime associates with each serializable class a version number,
called a serialVersionUID, which is used during deserialization to verify that the sender and receiver
of a serialized object have loaded classes for that object that are compatible with respect to serialization.
If the receiver has loaded a class for the object that has a different serialVersionUID than that of the corresponding
sender's class, then deserialization will result in an InvalidClassException. A serializable class can declare its own
serialVersionUID explicitly by declaring a field named "serialVersionUID" that must be static, final, and of type long:

ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;


Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that we can store it’s state in file system and retrieve it at later point of time.
 Here is a small singleton class that implements Serializable interface also.
 */


class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }


    //It ensures that after the deserialization, what object is returned is the same as was serialised
    protected Object readResolve() {
        return getInstance();
    }

}


public class SingletoneDesignPattern4 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "../filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "../filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        //So serialization destroys the singleton pattern
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

    }

}