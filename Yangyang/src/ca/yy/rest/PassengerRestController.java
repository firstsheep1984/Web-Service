package ca.yy.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.yy.entity.Address;
import ca.yy.entity.Passenger;
import ca.yy.entity.Gender;
import ca.yy.entity.Payment;
import ca.yy.entity.*;
import ca.yy.exception.*;

@RestController
@RequestMapping("/api")
public class PassengerRestController {

	private List<Passenger> thePassengers;

	@PostConstruct
	public void loadData() {

		thePassengers = new ArrayList<>();
		
		Address ad = new Address(157, "Rue", "Montreal", "QC", "CA", "H9L 9E2","2019-07-10", "Montreal","2019-07-11", "Ottawa");
		Address ad1 = new Address(168, "Street", "Ottawa", "ON", "CA", "K8E 5T6","2019-07-11", "Calgary","2019-07-11", "Ottawa");
		Address ad2 = new Address(155, "Row", "Ottawa", "ON", "CA", "G8C 5K7","2019-07-11", "Vancouver","2019-07-11", "Ottawa");
		Address ad3 = new Address(244, "Wall", "Ottawa", "ON", "CA", "J8E 3J8","2019-07-12", "Montreal","2019-07-11", "Ottawa");
		Address ad4 = new Address(465, "Lakes", "Montreal", "QC", "CA", "U9C 5J6","2019-07-12", "calgary","2019-07-11", "Montreal");

		Payment payment = new Payment("visa", 234);
		Payment payment1 = new Payment("master", 234);

		Gender gen = Gender.F;

		thePassengers.add(new Passenger("Sheldon", "Couper", "1998-07-11", "email","514",gen,payment,ad));
		thePassengers.add(new Passenger("Penny", "Rossi", "1980-01-11", "email", "438", gen, payment1, ad1));
		thePassengers.add(new Passenger("Leonard", "Smith", "1990-05-11", "email", "514", gen, payment, ad2));
		thePassengers.add(new Passenger("Yak", "Sang", "1998-05-14", "email", "438", gen, payment1, ad3));
		thePassengers.add(new Passenger("Ing", "Liu", "1885-75-11", "email", "514", gen, payment, ad4));
	}

	// list of all passengers
	@GetMapping("/passengers")
	public List<Passenger> getPassengers() {
		return thePassengers;
	}

	// show just one passenger by id
	@GetMapping("/passengers/{passengerId}")
	public Passenger getPassenger(@PathVariable int passengerId) {

		if ((passengerId >= thePassengers.size()) || (passengerId < 0)) {
			throw new PassengerNotFoundException("Passenger id not found -  " + passengerId);
		}

		return thePassengers.get(passengerId);
	}

	// find a passenger by family
	@GetMapping("/passengers/find/Rossi")
	public Passenger getPassengerByFamily() {
		int index = 0;
		for (int i = 0; i < thePassengers.size(); i++) {
			if (thePassengers.get(i).getFamily() == "Rossi") {
				index = i;
			}
		}

		return thePassengers.get(index);
	}
	
	
	// show list of passengers based on the destination city
	@GetMapping("/passengers/ottawa")
	public List<Passenger> getPassengersIntheSameCity() {

		List<Passenger> secondList = new ArrayList<>();

		for (Passenger p : thePassengers) {

			if (p.getAddress().getToDestinationCity() == "Ottawa") {

				secondList.add(p);
			}
		}

		return secondList;
	}

	// show list of passengers ordered by family
	@GetMapping("/passengers/sorted/family")
	public List<Passenger> getSortedPassengers() {
		// JAVA 8 - lambda expression
		return thePassengers.stream().sorted((p1, p2) -> p1.getFamily().compareTo(p2.getFamily()))
				.collect(Collectors.toList());

	}

	// show list of passengers by departure date
	@GetMapping("/passengers/find/departuredate")
	public List<Passenger> getPassengersIntheSameDepartureDate() {
		return thePassengers.stream().filter(p -> (p.getAddress().getFromDepartureDate() == "2019-07-11")).collect(Collectors.toList());
	}

	// delete
	@DeleteMapping("passengers/{passengerId}")
	public Passenger deletePassenger(@PathVariable int passengerId) {
		if ((passengerId >= thePassengers.size()) || (passengerId < 0)) {
			throw new PassengerNotFoundException("Passenger id not found -  " + passengerId);
		}
		return thePassengers.get(passengerId);
	}
}
