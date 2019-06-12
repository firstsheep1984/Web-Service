package ca.y.rest;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.y.entity.*;
//import ca.y.exception.StudentNotFoundException;
import ca.y.exception.*;

@RestController
@RequestMapping("/api")

public class CustomerRestController {
	private List<Customer> theCustomers;

	// We want to create the list of students only one time
	// in previous approach by each request every time new array of students was
	// built
	// with @PostConstruct student initialization will happened only one time
	@PostConstruct
	public void loadData() {

		theCustomers = new ArrayList<>();

		Address ad = new Address(157, "Rue", "Montreal", "QC", "CA", "H9L 9E2");
		Address ad1 = new Address(168, "Street", "Ottawa", "ON", "CA", "K8E 5T6");
		Address ad2 = new Address(155, "Row", "Ottawa", "ON", "CA", "G8C 5K7");
		Address ad3 = new Address(244, "Wall", "Ottawa", "ON", "CA", "J8E 3J8");
		Address ad4 = new Address(465, "Lakes", "Montreal", "QC", "CA", "U9C 5J6");

		Payment payment = new Payment("visa", 234);
		Payment payment1 = new Payment("master", 234);

		Gender gen = Gender.F;

		// theCustomers.add(new Customer("Sheldon",
		// "Couper",parsed,"EMAIL","514",gen,payment , ad));
		theCustomers.add(new Customer("Sheldon", "Couper", "2022-05-11", "email", "514", gen, payment, ad));
		theCustomers.add(new Customer("Ssaraaa", "Yanwer", "2011-11-14", "email", "438", gen, payment1, ad1));
		theCustomers.add(new Customer("Jack", "Sparral", "1990-05-11", "email", "514", gen, payment, ad2));
		theCustomers.add(new Customer("Yak", "Sang", "1998-05-14", "email", "438", gen, payment1, ad3));
		theCustomers.add(new Customer("Ing", "Liu", "1885-75-11", "email", "514", gen, payment, ad4));

	}

	// define end point for "/students" - return list of students
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return theCustomers;
	}

	// http://localhost:8080/03-REST-PathVariable/api/students/1
	// One at the end of URL is studentId and can be changed to other numbers
	// define end point for "/students/{studentId}" - return one student based on Id
	// studentId in the path should be the same as method argument
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		if ((customerId >= theCustomers.size()) || (customerId < 0)) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		return theCustomers.get(customerId);
	}

	@GetMapping("/customers/Ottawa")
	public List<Customer> getCustomersIntheSameCity() {
		// JAVA 8 - 
		// theCustomers.stream().filter(c ->
		// c.getAddress().getCity().contains("Ottawa"));
		// return theCustomers;

		List<Customer> secondList = new ArrayList<>();

		for (Customer c : theCustomers) {

			if (c.getAddress().getCity() == "Ottawa") {

				secondList.add(c);
			}
		}

		return secondList;
	}

	@GetMapping("/customers/find/{family}")
	public Customer getCustomer(@PathVariable String family) {
		int index = -1;
		for (int i = 0; i < theCustomers.size(); i++) {
			if (theCustomers.get(i).getFamily().equals(family)) {
				index = i;
				break;
			}
		}

		return theCustomers.get(index);
	}

	@GetMapping("/customers/sorted/family")
	public List<Customer> getSortedCustomers() {
		// JAVA 8 - lambda expression
		return theCustomers.stream().sorted((c1,c2) -> 
		 c1.getFamily().compareTo(c2.getFamily())).collect(Collectors.toList());
		 	
	}				
}
