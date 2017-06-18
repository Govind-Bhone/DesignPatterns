package structural;

/**
 * Created by govind.bhone on 6/18/2017.
 */
/*
Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other instances
of the same class will not be affected by this, so individual object gets the modified behavior. Decorator design pattern is one of the structural design pattern (such as
Adapter Pattern, Bridge Pattern, Composite Pattern) and uses abstract classes or interface with composition to implement.

We use inheritance or composition to extend the behavior of an object but this is done at compile time and its applicable
to all the instances of the class. We can’t
add any new functionality of remove any existing behavior at runtime – this is when Decorator pattern comes into picture.

Suppose we want to implement different kinds of cars – we can create interface Car to define the assemble method and
then we can have a Basic car, further more we can extend
it to Sports car and Luxury Car. The implementation hierarchy will look like below image.

But if we want to get a car at runtime that has both the features of sports car and luxury car, then the
implementation gets complex and if further more we want to specify which features should be added first, it gets even
 more complex. Now imagine if we have ten different kind of cars, the implementation logic using inheritance and composition will
be impossible to manage. To solve this kind of programming situation, we apply decorator pattern in java.
 */

interface Car {
    public void assemble();
}

class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }

}

class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c){
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}

class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

public class DecorativeDesignPattern {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
