package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.CustomerDto;
import com.exception.ResourceNotFoundException;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerContoller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService customerService = new CustomerService();
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("-------------- Customer Page -------------");
			System.out.println("___________________________________________");
			System.out.println("press 1. Total number of orders");
			System.out.println("press 2. View all Customer");
			System.out.println("press 3. Update Phone Number");
			System.out.println("press 0. Exit");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Customer Page");
				break;
			}

			switch (input) {
			case 1:
				try {
					List<CustomerDto> list = customerService.calculateTotalOrder();
					for (CustomerDto c : list) {
						System.out.println(c);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<Customer> list = customerService.findAll();
					for (Customer c : list) {
						System.out.println(c);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					List<Customer> list = customerService.findAll();
					for (Customer c : list) {
						System.out.println(c);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter Customer ID");
				int customerId = sc.nextInt();

				System.out.println("Enter Updated/ New Phone Number");

				int newPhone = sc.nextInt();

				try {
					customerService.updatePhone(customerId, newPhone);
					System.out.println("Address updated successfully");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}

				break;

			}
		}

		// sc.close();

	}

	public static void customerMenu() {
		String[] cust = { "" };
		main(cust);
	}

}
