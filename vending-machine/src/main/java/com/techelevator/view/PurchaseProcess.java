package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class PurchaseProcess {

    public double totalFedMoney = 0;

    public void feedMoney(double amount) {
        totalFedMoney += amount;
    }

    public void finishTransaction() {
        totalFedMoney = 0;
    }

    @Test
    public void test_Feed_Money() {
        PurchaseProcess purchaseProcess = new PurchaseProcess();
        double expectedTotalFedMoney = 7;
        purchaseProcess.feedMoney(7);
        double actualTotalFedMoney = purchaseProcess.totalFedMoney;
        Assert.assertEquals(expectedTotalFedMoney, actualTotalFedMoney, 0.001);
    }
}





