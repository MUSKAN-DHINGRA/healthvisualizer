package com.example.healthvisualizer;

public class ExampleClass {
    // Fields
    private String name;
    private int age;

    // Constructor
    public ExampleClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to print information about the object
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method for testing the class
    public static void main(String[] args) {
        // Creating an instance of ExampleClass
        ExampleClass example = new ExampleClass("John", 30);

        // Printing information about the object
        example.printInfo();
    }
}