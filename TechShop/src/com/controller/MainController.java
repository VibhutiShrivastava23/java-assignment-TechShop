package com.controller;

import java.util.Scanner;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(" \n            MAIN MENU            ");
			System.out.println("_____________________________________");
			System.out.println("Press 1. Customer Page");
			System.out.println("Press 2. Product Page");
			System.out.println("Press 3. Orders Page");
			System.out.println("Press 4. Order Detail Page");
			System.out.println("Press 5. Inventory Page");
			System.out.println("Press 0. Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Main Menu");
				break;
			}
			switch (input) {
			case 1:
				CustomerContoller.customerMenu();
				break;

			case 2:
				ProductController.productMenu();
				break;

			case 3:
				OrderController.orderMenu();
				break;

			case 4:
				OrderDetailController.orderDeatilMenu();
				break;

			case 5:
				InventoryController.inventoryMenu();
				break;

			default:
				System.out.println("invalid input");
			}

		}
		sc.close();
	}
}
