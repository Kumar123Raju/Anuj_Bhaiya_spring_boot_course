package com.example.ubberApp.ubberApp;

import com.example.ubberApp.ubberApp.Client.CustomerClient;
import com.example.ubberApp.ubberApp.dto.CustomerDto;
import org.apache.catalina.util.CustomObjectInputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class UbberAppApplicationTests {

	@Autowired
	private CustomerClient customerClient;

	@Test
	void saveCustomer(){
		CustomerDto customerDto=new CustomerDto();
		customerDto.setFirstName("Raju");
		customerDto.setLastName("kumar"); // Setting the last name
		customerDto.setEmail("rjrajujames123@gmail.com"); // Setting the email
		customerDto.setPhoneNumber("8582084483"); // Setting the phone number
		customerDto.setDateOfBirth(LocalDate.ofEpochDay(1990-05-15)); // Setting the date of birth
		customerDto.setAddress("Ranchi jharkhand"); // Setting the address

		CustomerDto customer=customerClient.saveCustomer(customerDto);
		if (customer != null) {
			System.out.println("ID: " + customer.getId());
			System.out.println("First Name: " + customer.getFirstName());
			System.out.println("Last Name: " + customer.getLastName());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Phone Number: " + customer.getPhoneNumber());
			System.out.println("Date of Birth: " + customer.getDateOfBirth());
			System.out.println("Address: " + customer.getAddress());
		} else {
			System.out.println("Save not done");
		}
	}


	@Test
	void getAllCustomer(){
		List<CustomerDto> customerDtoList=customerClient.getCustomer();
		if (customerDtoList != null && !customerDtoList.isEmpty()) {
			for (CustomerDto customer : customerDtoList) {
				System.out.println("ID: " + customer.getId());
				System.out.println("First Name: " + customer.getFirstName());
				System.out.println("Last Name: " + customer.getLastName());
				System.out.println("Email: " + customer.getEmail());
				System.out.println("Phone Number: " + customer.getPhoneNumber());
				System.out.println("Date of Birth: " + customer.getDateOfBirth());
				System.out.println("Address: " + customer.getAddress());
				System.out.println("--------------------");
			}
		} else {
			System.out.println("No customers found.");
		}
	}

	@Test
	void getCustomerById(){
		CustomerDto customer=customerClient.getCustomerById(2L);
		if (customer != null) {
				System.out.println("ID: " + customer.getId());
				System.out.println("First Name: " + customer.getFirstName());
				System.out.println("Last Name: " + customer.getLastName());
				System.out.println("Email: " + customer.getEmail());
				System.out.println("Phone Number: " + customer.getPhoneNumber());
				System.out.println("Date of Birth: " + customer.getDateOfBirth());
				System.out.println("Address: " + customer.getAddress());
		} else {
			System.out.println("No customers found.");
		}

	}


}
