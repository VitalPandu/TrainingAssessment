package com.automate;

import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String name;
    private int salary;
    private int uniqueIdentifier;
    private int age;

    public Employee(String name, int salary, int uniqueIdentifier,int age) {
        this.name = name;
        this.salary = salary;
        this.uniqueIdentifier = uniqueIdentifier;
        this.age=age;
    }

    public void displayInrotmation(){
        System.out.println("["+this.name+" "+this.salary+" "+
                this.uniqueIdentifier+" "+this.age+"]");

    }

    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }
}
