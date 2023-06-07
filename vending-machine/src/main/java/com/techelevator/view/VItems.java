package com.techelevator.view;

public class VItems {
    private String name;
    private double price;


    public VItems(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public VItems() {
    }

    public void makeSound() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}