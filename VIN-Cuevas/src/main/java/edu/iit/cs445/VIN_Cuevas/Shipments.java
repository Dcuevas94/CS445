package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;

public class Shipments {
	private String status;
	private int id;
	private ArrayList<Integer> wineIDs = new ArrayList<>();
	MonthlySelection ms;
	
	public Shipments(){
		this.status = "Delivered";
		this.id = IdGenerator.newIDship();
		wineIDs.add(this.id);
	}
	
	public Shipments(MonthlySelection ms, String status, int id){
		this.ms = ms;
		this.status = status;
		this.id = id;
		wineIDs.add(id);
	}
	
	public MonthlySelection getMonthlySelection(){
		return ms;
	}
	
	public String getStatus(){
		return status;
	}
	
	public int getShipmentIDs(){
		return id;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
