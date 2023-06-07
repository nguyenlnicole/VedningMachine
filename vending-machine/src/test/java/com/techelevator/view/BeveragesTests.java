package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class BeveragesTests {
    @Test
    public void test_gum() {
        String expectedName = "Dr. Salt";
        double expectedPrice = 1.50;

        Candy candy = new Candy(expectedName, expectedPrice);
        String actualName = candy.getName();
        double actualPrice = candy.getPrice();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0.001);

    }
}

