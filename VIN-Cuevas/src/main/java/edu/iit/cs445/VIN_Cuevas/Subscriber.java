package edu.iit.cs445.VIN_Cuevas;

public class Subscriber {

	private String name;
	private String email;
	private String phone;
	private String twitter;
	private String facebook;
	private Address address;
	private int id;
	private MonthlySelectionType monthlyselectiontype;
	
	public Subscriber(){
		int subID = IdGenerator.newID();
		this.name = "default Doe";
		this.email = "bob@gmail.com";
		this.phone = "123456789";
		this.address = new Address();
		this.monthlyselectiontype = MonthlySelectionType.RW;
		this.id = subID;
	}
	
	public Subscriber(String name, String email, String phone, Address address) {
		this.name = name;
		this.email = email;
		this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit
															// characters
		this.address = address;
		this.monthlyselectiontype = MonthlySelectionType.RW;
		this.id = IdGenerator.newID();
	}
//	public Address(){
//		this.street = "555 State St.";
//		this.city = "Chicago";
//		this.state = "IL";
//		this.zip = "60609";
//	}
//	
	public Subscriber(String name, String email, String phone, Address address, String fb, String tw) {
		this.name = name;
		this.email = email;
		this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit
															// characters
		this.address = address;
		this.twitter = tw;
		this.facebook = fb;
		this.monthlyselectiontype = MonthlySelectionType.RW;
		this.id = IdGenerator.newID();
	}

	public void updateInfo(String name, String email, String phone, Address address){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	private boolean isMatchName(String kw){
		String regex = "(?i).*" + kw + ".*";
		return this.name.matches(regex);
	}
	
	private boolean isMatchingEmail(String kw){
		String regex = "(?i).*" + kw + ".*";
		return this.email.matches(regex);
	}
	
	private boolean isMatchingPhone(String kw){
		String s = kw.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters from search string
		String regex = "(?i).*" + s + ".*";
		return this.phone.matches(regex);
	}
	
	//maybe add the isMatchName()
	public boolean isMatch(String kw){
		if(isMatchingEmail(kw) || isMatchingPhone(kw) || isMatchName(kw)){
			return true;
		} else return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}

	public MonthlySelectionType getPreference() {
		return monthlyselectiontype;
	}

	public void setPreference(MonthlySelectionType type) {
		this.monthlyselectiontype = type;
	}
	
    @Override
	public String toString(){
    	String output="The name of the Subscriber is " +name+ " The email is " +email+
    			" The phone number is " +phone+" The address is "  +address+
    			" The monthly selection is " +monthlyselectiontype;
    	return output;
    }
}
