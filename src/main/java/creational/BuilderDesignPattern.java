package creational;

/**
 * Created by govind.bhone on 6/6/2017.
 */
/*

I don't want to pass all the parameters each and everywhere and not remember even the sequence of it
 */

class Phone {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }

    public Phone(String os, int ram, String processor, double screenSize, int battery) {
        super();
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
    }
}

class PhoneBuilder{
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone(){
        return new Phone(os,ram,processor,screenSize,battery);
    }
}

public class BuilderDesignPattern {
    public static void main(String args[]) {
        PhoneBuilder pb = new PhoneBuilder();
        pb.setOs("android").setRam(2);

        System.out.println(pb.getPhone());

    }
}
