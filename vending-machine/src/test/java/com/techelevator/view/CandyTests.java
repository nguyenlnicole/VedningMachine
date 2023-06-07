package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class CandyTests {
@Test
    public void test_candy() {
    String expectedName = "Moonpie";
    double expectedPrice = 1.80;

    Candy candy = new Candy(expectedName, expectedPrice);
    String actualName = candy.getName();
    double actualPrice = candy.getPrice();

    Assert.assertEquals(expectedName, actualName);
    Assert.assertEquals(expectedPrice, actualPrice, 0.001);

    }

}
