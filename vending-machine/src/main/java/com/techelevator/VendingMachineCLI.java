package com.techelevator;

import com.techelevator.util.LogFile;
import com.techelevator.view.DateAndTime;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseProcess;
import com.techelevator.view.VItems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;
	private Scanner input;

	private double vendingMachineBalance = 0;
	private int vendingMachineStock = 5;

	private PurchaseProcess purchaseProcess;
	private DateAndTime dateAndTime;

	private List<String> slotNumbers;
	private List<String> productNames;
	private List<Double> productCosts;
	private List<String> productClasses;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.input = new Scanner(System.in);
		this.purchaseProcess = new PurchaseProcess();
		this.dateAndTime = new DateAndTime();

		this.slotNumbers = new ArrayList<>();
		this.productNames = new ArrayList<>();
		this.productCosts = new ArrayList<>();
		this.productClasses = new ArrayList<>();
	}

	public void run() {
		loadInventoryFile();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				processPurchase();
			} else {
				break; // Exit the program
			}
		}
	}

	private void loadInventoryFile() {
		File inventoryFile = new File("vendingmachine.csv");
		try (Scanner scanFile = new Scanner(inventoryFile)) {
			while (scanFile.hasNextLine()) {
				String displayOutput = scanFile.nextLine();
				String[] lines = displayOutput.split("\\|");
				slotNumbers.add(lines[0]);
				productNames.add(lines[1]);
				double cost = Double.parseDouble(lines[2]);
				productCosts.add(cost);
				productClasses.add(lines[3]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error finding file");
			System.exit(1); // Exit the program if the file is not found
		}
	}

	public void displayVendingMachineItems() {
		for (int i = 0; i < slotNumbers.size(); i++) {
			String slotNumber = slotNumbers.get(i);
			String productName = productNames.get(i);
			double productCost = productCosts.get(i);
			String productClass = productClasses.get(i);
			System.out.printf("%s %s $%.2f %s%n", slotNumber, productName, productCost, productClass);
		}
	}

	public void processPurchase() {
		double total = 0;
		String ans = "Y";
		Scanner productScanner = new Scanner(System.in);
		while (ans.equals("Y")) {
			if (vendingMachineStock == 0) {
				System.out.println("ITEM SOLD OUT");
				break; // Add a break statement to exit the loop when the item is sold out
			}
			System.out.println("Enter the slot number to choose an item");
			String slotID = productScanner.nextLine();
			int pos = slotNumbers.indexOf(slotID);

			if (pos == -1) {
				System.out.println("Invalid slot number");
				continue;
			}

			double cost = productCosts.get(pos);
			total += cost;
			System.out.printf("The total amount is: $%.2f\n", total);
			System.out.println("Would you like to choose another item? (Y/N)");
			ans = productScanner.nextLine().toUpperCase();

			vendingMachineStock--; // Decrement the stock for each purchased item

			if (!ans.equals("Y")) {
				break;
			}
		}


		System.out.println("Enter the total number of bills: ");
		double totalBills = input.nextDouble();

		LogFile.log(dateAndTime.getAmPm() + " FEED MONEY: $" + totalBills + " $");

		double totalChangeGivenBack = totalBills - total;
		System.out.println("Your change is: $" + totalChangeGivenBack);
		int changeInPennies;

		totalChangeGivenBack = totalChangeGivenBack * 100;
		changeInPennies = (int) totalChangeGivenBack;

		int quarters = changeInPennies / 25;
		changeInPennies %= 25;

		int dimes = changeInPennies / 10;
		changeInPennies %= 10;

		int nickels = changeInPennies / 5;
		changeInPennies %= 5;

		int pennies = changeInPennies;

		System.out.println("Change in coins: Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels + " Pennies: " + pennies);
		System.out.println("Please take your change");

		boolean hasPrinted = false;
		for (int i = 0; i < productClasses.size(); i++) {
			if (productClasses.get(i).equals("Chip")) {
				if (!hasPrinted) {
					System.out.println("Crunch Crunch, Yum");
					hasPrinted = true;
				}
			} else if (productClasses.get(i).equals("Gum")) {
				if (!hasPrinted) {
					System.out.println("Chew Chew, Yum");
					hasPrinted = true;
				}
			} else if (productClasses.get(i).equals("Drink")) {
				if (!hasPrinted) {
					System.out.println("Glug Glug, Yum");
					hasPrinted = true;
				}
			} else if (productClasses.get(i).equals("Candy")) {
				if (!hasPrinted) {
					System.out.println("Munch Munch, Yum");
					hasPrinted = true;
				}
			}
		}

		vendingMachineBalance += totalBills - (double) changeInPennies;
		LogFile.log(dateAndTime.getAmPm() + " GIVE CHANGE: $" + (double) totalChangeGivenBack + " $");

		System.out.println();
		System.out.println();
		purchaseProcess.finishTransaction();
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

