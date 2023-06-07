package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class GumTests {
    @Test
    public void test_gum() {
        String expectedName = "U-Chews";
        double expectedPrice = .85;

        Candy candy = new Candy(expectedName, expectedPrice);
        String actualName = candy.getName();
        double actualPrice = candy.getPrice();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0.001);

    }
}
