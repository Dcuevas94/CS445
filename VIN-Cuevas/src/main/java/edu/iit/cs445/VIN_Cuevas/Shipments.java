package edu.iit.cs445.VIN_Cuevas;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shipments {
	private int id;
	private ShipmentStatus status;
	private MonthlySelection ms;
	private int quantity;
	private double price;
	private double deliveryFee;
	private YearMonth yearMonth;// = DateTimeFormatter.ofPattern("MM-yyyy");
	private List<Note> notes;
	private Date date;
	
	public Shipments(){
		this.id = IdGenerator.newIDship();
		this.status = ShipmentStatus.PENDING;
		this.quantity = 1;
		this.ms = new RW();
		this.price = 25.99;
		this.deliveryFee = 3.99;
		this.yearMonth = YearMonth.now();
		this.notes = new ArrayList<Note>();
		this.date = new Date();
	}
	
	public Shipments(MonthlySelection ms, String yearMonth){
		this.ms = ms;
		this.id = IdGenerator.newIDship();;
		this.status = ShipmentStatus.PENDING;
		this.quantity = 1;
		this.ms = new RW();
		this.price = 25.99;
		this.deliveryFee = 3.99;
		this.yearMonth = YearMonth.now();
		this.notes = new ArrayList<Note>();
		this.date = new Date();
	}
	
	public MonthlySelection getMonthlySelection(){
		return ms;
	}
	
	public ShipmentStatus getStatus(){
		return status;
	}
	
	public Date getDate(){
		return date;
	}
	
	public List<Note> getNotes(){
		return notes;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getDeliveryFee(){
		return deliveryFee;
	}
	
	public int getShipmentIDs(){
		return id;
	}

	public YearMonth getYearMonth(){
		return yearMonth;
	}
	
	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}
	
	public void setMonthlySelection(MonthlySelection ms){
		this.ms = ms;
	}
	
	public void setQuantity(int quant){
		this.quantity = quant;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setDeliveryFee(double deliveryFee){
		this.deliveryFee = deliveryFee;
	}
	
	public void setYearMonth(YearMonth yearMonth){
		 this.yearMonth = yearMonth;
	}
	
	public String setCurrentDate(){
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
		String theDate = format.format(currentDate);
		return theDate;
	}
	
	public void addNote(Note note){
		if(note.getContent().length()<40){
			System.err.println("Length must be more than 40 characters long");
		} else if(note.getContent().length()>1024){
			System.err.println("Length must be less than 1024 characters");
		} else 
			notes.add(note);
	}
	
	public void deleteNote (Note note){
		notes.remove(note);
	}
	
	public void setNotes(List<Note> notes){
		this.notes = notes;
	}
}