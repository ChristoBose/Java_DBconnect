package com.ilp04.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {

	
	//get connection
	
	public Connection getConnection() {
		
		String connectionURL= "jdbc:mysql://localhost:3306/bankdb";
		String userName = "root";
		String password = "experion@123";
		
		
//		String connectionURL = "jdbc:mysql://localhost/" + "bankdb" + "?user=" + "root" + "&password=" + password + "&useUnicode=true&characterEncoding=UTF-8";
//		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return connection;
		
		
	}
	
	
	//close connection
	
	public Connection closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	//get all customer details
	
	public ArrayList<Customer> getAllCustomers(Connection connection){
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		try {
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery("select * from customer");
			
			
			while(resultSet.next())
			{
				int customerCode = resultSet.getInt(1);
				String customerFirstname = resultSet.getString(2);
				String customerLastname = resultSet.getString(3);
				String address = resultSet.getString(4);
				int age = resultSet.getInt(5);
				long phoneNumber = resultSet.getLong(6);
				long aadharNumber = resultSet.getLong(7);
				Customer customer = new Customer(customerCode,customerFirstname,customerLastname,address,age,phoneNumber,aadharNumber);
				customerList.add(customer);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}
	
	public int insertCustomer(Customer customer, Connection connection) {
        Statement statement = null;
        int rowsAffected = 0;

        try {
            statement = connection.createStatement();

            String insertQuery = "INSERT INTO customer (customer_code, customer_firstname, customer_lastname, address, phonenumber, aadharno) " +
                                "VALUES (" + customer.getCustomerCode() + ", '" + customer.getCustomerFirstname() + "', '" + customer.getCustomerLastname() + "', '" + 
                                customer.getAddress() + "', " + customer.getPhoneNumber() + ", " + customer.getAadharNumber() + ")";
            
            rowsAffected = statement.executeUpdate(insertQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected;
    }
	
	public int updateCustomer(Customer customer, Connection connection) {
        PreparedStatement statement = null;
        int rowsAffected = 0;
        
        try {
        	String updateQuery = "UPDATE customer SET customer_firstname=?,customer_lastname=?,address=?,age=?,phonenumber=?,aadharno=? where customer_code=?";
            statement = connection.prepareStatement(updateQuery);
            statement.setString(1, customer.getCustomerFirstname());
            statement.setString(2, customer.getCustomerLastname());
            statement.setString(3, customer.getAddress());
            statement.setInt(4, customer.getAge());
            statement.setLong(5, customer.getPhoneNumber());
            statement.setLong(6, customer.getAadharNumber());
            statement.setInt(7, customer.getCustomerCode());
            rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected;
    }
	
	
	
	
	
	
}
