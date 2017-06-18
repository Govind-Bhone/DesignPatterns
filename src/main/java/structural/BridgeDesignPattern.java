package structural;

/**
 * Created by govind.bhone on 6/18/2017.
 */

/*
When we have interface hierarchies in both interfaces as well as implementations, then bridge design pattern is used to
decouple the interfaces from implementation and hiding the implementation details from the client programs.

Decouple an abstraction from its implementation so that the two can vary independently

it uses composition over inheritance
*/
interface Color {
    public void applyColor();
}

abstract class Shape2 {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape2(Color c) {
        this.color = c;
    }

    abstract public void applyColor();
}

class Triangle2 extends Shape2 {

    public Triangle2(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }

}

class Pentagon2 extends Shape2 {

    public Pentagon2(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }

}

class RedColor implements Color {

    public void applyColor() {
        System.out.println("red.");
    }
}

class GreenColor implements Color {
    public void applyColor() {
        System.out.println("green.");
    }
}

public class BridgeDesignPattern {
    public static void main(String[] args) {
        Shape2 tri = new Triangle2(new RedColor());
        tri.applyColor();

        Shape2 pent = new Pentagon2(new GreenColor());
        pent.applyColor();
    }
}
