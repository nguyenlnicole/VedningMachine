package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTests {
    @Test
    public void test_Chips() {
        String expectedName = "Grain Waves";
        double expectedPrice = 2.75;

        Candy candy = new Candy(expectedName, expectedPrice);
        String actualName = candy.getName();
        double actualPrice = candy.getPrice();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0.001);

    }
}
