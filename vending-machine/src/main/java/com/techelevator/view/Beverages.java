package com.techelevator.view;

public class Beverages extends VItems {

    public Beverages(String name, double price) {

        super(name, price);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Glug Glug, Yum");
    }
}
