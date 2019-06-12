package ca.y.entity;

import java.util.Date;

public class Customer {
	private String name;
	private String family;
	private String birthdate;
	private String email;
	private String phone;
	private Gender gender;
	private Payment payment;
	private Address address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String family, String birthdate, String email, String phone, Gender gender,
			Payment payment, Address address) {
		super();
		this.name = name;
		this.family = family;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.payment = payment;
		this.address = address;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCity() {
		return address.getCity();
	}

}
