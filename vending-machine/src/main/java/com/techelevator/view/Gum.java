package com.techelevator.view;

public class Gum extends VItems {


    public Gum(String name, double price) {
        super(name, price);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Chew Chew, Yum");
    }


}
