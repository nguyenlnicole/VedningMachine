package com.techelevator.view;

public class Chips extends VItems {


    public Chips(String name, double price) {
        super(name, price);
    }

    @Override
        public void makeSound() {
            super.makeSound();
            System.out.println("Crunch Crunch, Yum");
        }
    }



