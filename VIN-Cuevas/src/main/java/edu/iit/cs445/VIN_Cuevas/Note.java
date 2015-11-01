package edu.iit.cs445.VIN_Cuevas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
	private int id;
	private Date date;
	private String content;

	public Note(){
		this.id = IdGenerator.newIDnote();
		this.date = new Date();
		this.content = "";
	}
	
	public Note(String content){
		this.id = IdGenerator.newIDnote();
		this.date = new Date();
		this.content = content;
	}
	
	public Date getDate(){
		return date;
	}
	
	public String getContent(){
		return content;
	}
	
	public int getID(){
		return id;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public void modifyContent(String content){
		this.setContent(content);
	}
	
	public String setCurrentDate(){
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
		String theDate = format.format(currentDate);
		return theDate;
	}
}
