package edu.iit.cs445.VIN_Cuevas;

public class Address {

	private String street, city, state, zip;
	
	public Address(){
		this.street = "555 State St.";
		this.city = "Chicago";
		this.state = "IL";
		this.zip = "60609";
	}
	
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public boolean isMatch(Address address){
		if( isMatchCity(address.city) &&
			isMatchState(address.state) &&
			isMatchStreet(address.street) &&
			isMatchZip(address.zip)){
			return true;
		} else
			return false;
	}
	
	public boolean isMatchCity(String kw){
		String regex = "(?i).*" + kw + ".*";
		return this.getCity().matches(regex);
	}
	
	public boolean isMatchState(String kw){
		String regex = "(?i).*" + kw + ".*";
		return this.getState().matches(regex);
	}
	
	public boolean isMatchStreet(String kw){
		String regex = "(?i).*" + kw + ".*";
		return this.getStreet().matches(regex);
	}
	
	public boolean isMatchZip(String kw){
		String regex = "(?i).*" + kw + ".*";
		return this.getZip().matches(regex);
	}
}
