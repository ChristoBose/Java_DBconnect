package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

	public static void main(String[] args) {
		char goToMainMenu;
		int choice;
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.Display All Customers, 2.Insert, 3.Update ");
			choice = scanner.nextInt();
			switch(choice) {
				case 1:
					getAllCustomers();
				case 2:
					insertValues();
				case 3:
					updateValues();
				
			}
			
			System.out.println("Go to main menu(y/n");
			goToMainMenu = scanner.next().charAt(0);
			
		}while(goToMainMenu=='y');
		
		getAllCustomers();
	}
	
	private static void getAllCustomers() {
		CustomerService customerService = new CustomerServiceImpl();
		ArrayList<Customer> customerList = customerService.getAllCustomers();
		
		
		for(Customer customer:customerList) {
			
			System.out.println("Customer Code : "+customer.getCustomerCode());
			System.out.println("First Name : "+customer.getCustomerFirstname());
			System.out.println("Address : "+customer.getAddress());
			System.out.println("Aadhar Number : "+customer.getAge());
			System.out.println("Phone Number : "+customer.getPhoneNumber());
			System.out.println("Aadhar Number : "+customer.getAadharNumber());
			
		}
			
	}
	
	
	
	private static void insertValues() {
		
		CustomerService customerService = new CustomerServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Consume newline character left by nextInt()

        System.out.print("Enter customer code: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()

        System.out.print("Enter customer first name: ");
        String customerFirstname = scanner.nextLine();

        System.out.print("Enter customer last name: ");
        String customerLastname = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline character left by nextLong()

        System.out.print("Enter Aadhar number: ");
        long aadharNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline character left by nextLong()

        Customer newCustomer = new Customer(customerCode, customerFirstname, customerLastname, address,age, phoneNumber, aadharNumber);
        
        int rowsInserted = customerService.insertIntoCustomer(newCustomer);

        if (rowsInserted > 0) {
            System.out.println("Customer inserted successfully! : "+rowsInserted);
        } else {
            System.out.println("Failed to insert customer.");
        }
    }
	
	
	private static void updateValues() {
		
		CustomerService customerService = new CustomerServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Consume newline character left by nextInt()

        System.out.print("Enter customer code of the customer you want to update : ");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()

        System.out.print("Enter new customer first name: ");
        String customerFirstname = scanner.nextLine();

        System.out.print("Enter new customer last name: ");
        String customerLastname = scanner.nextLine();

        System.out.print("Enter new address: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextLong()

        System.out.print("Enter new phone number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline character left by nextLong()

        System.out.print("Enter new Aadhar number: ");
        long aadharNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline character left by nextLong()

        Customer newCustomer = new Customer(customerCode, customerFirstname, customerLastname, address, age, phoneNumber, aadharNumber);
        
        int rowsUpdated = customerService.updateCustomer(newCustomer);

        if (rowsUpdated > 0) {
            System.out.println("Customer Updateed successfully! : "+rowsUpdated);
        } else {
            System.out.println("Failed to insert customer.");
        }
    }

		
		
	
}
