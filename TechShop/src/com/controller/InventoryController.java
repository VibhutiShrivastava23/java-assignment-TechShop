package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderDetailDto;
import com.dto.ProductInventoryDto;
import com.model.Inventory;
import com.model.OrderDetails;
import com.service.InventoryService;

public class InventoryController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InventoryService inventoryService = new InventoryService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n -------------------- Inventory Page --------------------");
			System.out.println("___________________________________________________________");
			System.out.println("Press 1. View Products in Inventory ");
			System.out.println("Press 2. Quantity of Product ");
			System.out.println("Press 3. Check Out of Stock");
			System.out.println("Press 0. to Exit");

			// The other method invlove CRUD and DTOs
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Inventory Module..");
				break;
			}

			switch (input) {
			case 1:
				try {
					List<ProductInventoryDto> list = inventoryService.findAll();
					for (ProductInventoryDto p : list) {
						System.out.println(p);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					List<Inventory> list = inventoryService.getQuantityInStock();
					for (Inventory i : list) {
						System.out.println(i);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					List<Inventory> list = inventoryService.getOutOfStock();
					for (Inventory i : list) {
						System.out.println(i);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			}
		}
		// sc.close();
	}

	public static void inventoryMenu() {
		// TODO Auto-generated method stub
		String[] inventory = { "" };
		main(inventory);

	}

}
