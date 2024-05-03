package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderDto;
import com.exception.ResourceNotFoundException;
import com.model.OrderDetails;
import com.model.Orders;
import com.service.OrderService;

public class OrderController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderService orderService = new OrderService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n -------------------- Order Page --------------------");
			System.out.println("_________________________________________________________");
			System.out.println("Press 1. Total Amount of Orders ");
			System.out.println("Press 2. View All Orders ");
			System.out.println("Press 3. Update Order Status");
			System.out.println("Press 4. Cancle Order (by soft delete)");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Order Module..");
				break;
			}

			switch (input) {
			case 1:
				try {
					List<OrderDto> list = orderService.totalAmount();
					for (OrderDto o : list) {
						System.out.println(o);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					List<Orders> list = orderService.findAll();
					for (Orders o : list) {
						System.out.println(o);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					List<OrderDetails> list = orderService.getOrderDetail();
					for (OrderDetails o : list) {
						System.out.println(o);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Enter Order Id");
				sc.nextLine();
				int oid = sc.nextInt();

				System.out.println("Enter Updated Status of Order(Processing,shipped)");
				sc.nextLine();
				String status = sc.nextLine();

				try {
					orderService.updateStatus(oid, status);
					System.out.println("Status updated successfully");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					List<Orders> list = orderService.findAll();
					for (Orders o : list) {
						System.out.println(o);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Enter order ID");
				int id = sc.nextInt();

				try {
					orderService.softDeleteByid(id);
					System.out.println("Record de-activated..");
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			}

		}
//sc.close();
	}

	public static void orderMenu() {
		// TODO Auto-generated method stub
		String[] order = { "" };
		main(order);

	}
}