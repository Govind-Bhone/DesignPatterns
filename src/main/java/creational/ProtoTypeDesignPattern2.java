package creational;

/**
 * Created by govind.bhone on 6/6/2017.
 */

interface ProtoType<T> extends Cloneable {
    public T clone() throws CloneNotSupportedException;
}

class Sheep implements ProtoType<Sheep> {

    private Shepard shepard = new Shepard();

    public Shepard getShepard() {
        return shepard;
    }

    public void setShepard(Shepard shepard) {
        this.shepard = shepard;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "shepard=" + shepard +
                '}';
    }

    public Sheep clone() throws CloneNotSupportedException {
        Sheep clone = (Sheep) super.clone();
        clone.setShepard(clone.getShepard().clone());
        return clone;
    }
}

class Shepard implements ProtoType<Shepard> {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Shepard{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shepard clone() throws CloneNotSupportedException {
        return (Shepard) super.clone();
    }
}

public class ProtoTypeDesignPattern2 {
    public static void main(String args[]) throws CloneNotSupportedException {
        Shepard sh = new Shepard();
        sh.setName("chintu");
        Sheep s1 = new Sheep();
        s1.setShepard(sh);
        System.out.println(s1);

        Sheep s2 = s1.clone();
        sh.setName("pintu");
        s1.setShepard(sh);
        System.out.println(s2);
    }
}
