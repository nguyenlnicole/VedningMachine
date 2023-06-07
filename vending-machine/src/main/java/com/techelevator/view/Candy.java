package com.techelevator.view;

public class Candy extends VItems {


    public Candy(String name, double price) {
        super(name, price);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Munch Munch, Yum");
    }
}
