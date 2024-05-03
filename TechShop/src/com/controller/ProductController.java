package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.ProductDto;
import com.exception.ResourceNotFoundException;
import com.model.Product;
import com.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		ProductService productService = new ProductService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n-------------- Product Page -------------");
			System.out.println("___________________________________________");
			System.out.println("press 1. View All Product");
			System.out.println("press 2. Update Product Price");
			System.out.println("press 3. Check Product Availability");
			System.out.println("press 0. Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Product Module");
				break; 
			}
		switch(input) {
		case 1:
			try {
				List<Product> list=productService.findAll();
				for(Product p :list){
					System.out.println(p);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
				
			
		break;
		case 2:
			try {
				List<Product> list=productService.findAll();
				for(Product p :list){
					System.out.println(p);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Enter Product Id");
			
			int id=sc.nextInt();
			
			System.out.println("Enter Updated Price");
			int price=sc.nextInt();
			
			try {
				productService.updatePrice(id,price);
				System.out.println("Price updated successfully");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (ResourceNotFoundException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 3:
			try {
				List<ProductDto> list=productService.checkStock();
				for(ProductDto pd :list) {
					System.out.println(pd);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}	
		break;
		
		default: 
			System.out.println("Invalid option");
		}
			
}
		//sc.close();
}

	public static void productMenu() {
		// TODO Auto-generated method stub
		String[] pro= {""};
		main (pro);
		
	}
}