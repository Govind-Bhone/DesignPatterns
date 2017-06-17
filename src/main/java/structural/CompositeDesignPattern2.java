package structural;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by govind.bhone on 6/17/2017.
 */
/*
Composite design patten allows you to have a tree structure and ask each node in the tree structure to perform a task.You can
take real life example of a
organization.It have general managers and under general managers, there can be managers and  under managers there can be
 developers.Now you can set a tree structure and ask each node to perform common operation like getSalary().

As described by Gof:

"Compose objects into tree structure to represent part-whole hierarchies.Composite lets client treat individual objects and
compositions of objects uniformly".

Composite design pattern treats each node in two ways-Composite or leaf.Composite means it can have other objects below
it.leaf means it has no objects below it.
 */

interface Employee {

    public void add(Employee employee);

    public void remove(Employee employee);

    public Employee getChild(int i);

    public String getName();

    public double getSalary();

    public void print();

    public double totalDecendentSalary();
}

class Manager implements Employee {

    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    List<Employee> employees = new ArrayList<Employee>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee getChild(int i) {
        return employees.get(i);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void print() {
        System.out.println("-------------");
        System.out.println("Name =" + getName());
        System.out.println("Salary =" + getSalary());
        System.out.println("-------------");

        Iterator<Employee> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            employee.print();
        }
    }

    @Override
    public double totalDecendentSalary() {
        double totalSalary = this.salary;
        Iterator<Employee> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (employee instanceof Manager) {
                totalSalary += employee.totalDecendentSalary();
            } else {
                totalSalary += employee.getSalary();
            }

        }
        return totalSalary;
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

}

class Developer implements Employee {

    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void add(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }

    public Employee getChild(int i) {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void print() {
        System.out.println("-------------");
        System.out.println("Name =" + getName());
        System.out.println("Salary =" + getSalary());
        System.out.println("-------------");
    }

    @Override
    public double totalDecendentSalary() {
        return getSalary();
    }

    public void remove(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }

}

public class CompositeDesignPattern2 {
    public static void main(String[] args) {
        Employee emp1 = new Developer("John", 10000);
        Employee emp2 = new Developer("David", 15000);
        Employee manager1 = new Manager("Daniel", 25000);
        manager1.add(emp1);
        manager1.add(emp2);
        Employee emp3 = new Developer("Michael", 20000);
        Manager generalManager = new Manager("Mark", 50000);
        generalManager.add(emp3);
        generalManager.add(manager1);
        generalManager.print();
        System.out.println(generalManager.totalDecendentSalary());
        System.out.println(emp1.totalDecendentSalary());
    }
}
