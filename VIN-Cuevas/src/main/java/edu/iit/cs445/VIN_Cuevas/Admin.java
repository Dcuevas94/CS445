package edu.iit.cs445.VIN_Cuevas;

public class Admin {
	private String name;
	private String email;
	private int id;
	
	public Admin(){
		this.name = "John Admin";
		this.email = "jAdams@gmail.com";
		this.id = IdGenerator.newIDadmin();
	}
	
	public Admin(String name, String email){
		this.name = name;
		this.email = email;
		this.id = IdGenerator.newIDadmin();
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}
	
	public String getEmail(){
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	@Override
	public String toString(){
		String output = "Admin name: "+this.name+"\nID: "+this.id+"\nEmail: "+this.email+"\n";
		return output;
	}
}
