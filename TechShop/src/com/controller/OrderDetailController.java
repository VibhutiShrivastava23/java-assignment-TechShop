package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderDetailDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;
import com.service.OrderDetailService;

public class OrderDetailController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDetailService orderDetailService = new OrderDetailService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n -------------------- Order Detail Page --------------------");
			System.out.println("________________________________________________________");
			System.out.println("Press 1. Sub Total of Order Detail ");
			System.out.println("Press 2. View All Order Details ");
			System.out.println("Press 3. Update Quantity in Order");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Order Detail Module..");
				break;
			}

			switch (input) {

			case 1:
				try {
					List<OrderDetailDto> list = orderDetailService.getSubtotal();
					for (OrderDetailDto d : list) {
						System.out.println(d);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<OrderDetails> list = orderDetailService.findAll();
					for (OrderDetails d : list) {
						System.out.println(d);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:

				try {
					List<OrderDetails> list = orderDetailService.findAll();
					for (OrderDetails o : list) {
						System.out.println(o);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter order id ");
				int id = sc.nextInt();

				System.out.println("Enter New Stock Quantity");
				int newQuantity = sc.nextInt();
				try {
					orderDetailService.updateQuantity(id, newQuantity);
					System.out.println("Updated successfully.");
					;
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

	public static void orderDeatilMenu() {
		// TODO Auto-generated method stub
		String[] od = { "" };
		main(od);

	}
}
