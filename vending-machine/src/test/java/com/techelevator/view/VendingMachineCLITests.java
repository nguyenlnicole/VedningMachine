package com.techelevator.view;

import com.techelevator.VendingMachineCLI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class VendingMachineCLITests {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOutput;
    private InputStream originalInput;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOutput = System.out;
        originalInput = System.in;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    @Test
    public void testDisplayVendingMachineItems() {
        // Create a Menu object and pass it to VendingMachineCLI constructor
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI vendingMachineCLI = new VendingMachineCLI(menu);

        // Call the displayVendingMachineItems method and verify the output
        System.out.println("Testing displayVendingMachineItems method:");
        vendingMachineCLI.displayVendingMachineItems();
        System.out.println("-------------------------------------------");
    }

    private String getOutput() {
        return outputStream.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");
    }
}