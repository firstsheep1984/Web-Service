package ca.yy.entity;

public class Address {
	private int number;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String fromDepartureDate;
	private String fromDepartureCity;
	private String toDestinationDate;
	private String toDestinationCity;
	
	public Address(int number, String streetAddress, String city, String state, String country, String zipcode,
			String fromDepartureDate, String fromDestinationCity, String toDepartureDate, String toDestinationCity) {
		super();
		this.number = number;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.fromDepartureDate = fromDepartureDate;
		this.fromDepartureCity = fromDestinationCity;
		this.toDestinationDate = toDepartureDate;
		this.toDestinationCity = toDestinationCity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getFromDepartureDate() {
		return fromDepartureDate;
	}
	public void setFromDepartureDate(String fromDepartureDate) {
		this.fromDepartureDate = fromDepartureDate;
	}
	public String getFromDepartureCity() {
		return fromDepartureCity;
	}
	public void setFromDepartureCity(String fromDestinationCity) {
		this.fromDepartureCity = fromDestinationCity;
	}
	public String getDestinationDate() {
		return toDestinationDate;
	}
	public void setToDestinationDate(String toDepartureDate) {
		this.toDestinationDate = toDepartureDate;
	}
	public String getToDestinationCity() {
		return toDestinationCity;
	}
	public void setToDestinationCity(String toDestinationCity) {
		this.toDestinationCity = toDestinationCity;
	}
	
	

}
