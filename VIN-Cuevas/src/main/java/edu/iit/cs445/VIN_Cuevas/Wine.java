package edu.iit.cs445.VIN_Cuevas;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Wine {
	private String labelName;
	private String grape;
	private String region;
	private String country;
	private String maker;
	private int numberOfRatings;
	private float rating = 0; //was double
	private int ID;
	private Year year;
	private WineVariety wineVariety;
	private WineType wineType;
	private List<Note> notes;
	
	public Wine(){
		this.labelName = "The Mission";
		this.grape = "Cabernet Sauvignon";
		this.region = "Napa";
		this.country = "USA";
		this.maker = "Sterling";
		this.year = Year.parse("2011");
		this.wineType = WineType.TABLE;
		this.wineVariety = WineVariety.RED;
		this.ID = IdGenerator.newIDwine();
		notes = new ArrayList<Note>();
	}
	
	public Wine(WineVariety winevariety, WineType winetype, String labelname, String grape, String region, String country, String maker, Year year){
		this.labelName = labelname;
		this.grape = grape;
		this.region = region;
		this.country = country;
		this.maker = maker;
		this.year = year;
		this.wineType = winetype;
		this.wineVariety = winevariety;
		this.ID = IdGenerator.newIDwine();
		notes = new ArrayList<Note>();
	}
	
	public void addRating(int rate){
		if ( rate <= 10 && rate >= 0){
			numberOfRatings++;
			rating = rating*((float)(numberOfRatings - 1)/numberOfRatings)+ (float)rate/numberOfRatings;
		} else
		{
			System.out.println("Rating must be between 1 and 10");
		}
	}
	

	public boolean isMatch(Wine kw){
		if(isMatchVariety(kw.getWineVariety()) &&
			isMatchType(kw.getWineType()) &&
			isMatchLabel(kw.getLabelName()) &&
			isMatchGrape(kw.getGrape()) &&
			isMatchRegion(kw.getRegion()) &&
			isMatchCountry(kw.getCountry()) &&
			isMatchMaker(kw.getMaker()) &&
			isMatchYear(kw.getYear())) 
		{
			return true;
		} else
			return false;
	}
	
	public boolean isMatchVariety(WineVariety kw){
		return this.getWineVariety().equals(kw);
		//return this.wineVariety.name().matches(regex);
	}
	
	public boolean isMatchType(WineType kw){
		return this.getWineType().equals(kw);
		//return this.wineType.name().matches(regex);
	}
	
	public boolean isMatchLabel(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.getLabelName().matches(regex);
	}
	
	public boolean isMatchGrape(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.getGrape().matches(regex);
	}
	
	public boolean isMatchRegion(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.getRegion().matches(regex);
	}
	
	public boolean isMatchCountry(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.getCountry().matches(regex);
	}
	
	public boolean isMatchMaker(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.getMaker().matches(regex);
	}
	
	public boolean isMatchYear(String kw){
		return this.getYear().toString().matches(kw);
	}
	
	public String getLabelName() {
		return labelName;
	}

	public String getGrape() {
		return grape;
	}

	public String getRegion() {
		return region;
	}

	public String getCountry() {
		return country;
	}

	public String getMaker() {
		return maker;
	}

	public int getNumberOfRatings() {
		return numberOfRatings;
	}

	public float getRating() {
		return rating;
	}

	public int getID() {
		return ID;
	}

	public String getYear() {
		return year.toString();
	}

	public WineVariety getWineVariety() {
		return wineVariety;
	}

	public WineType getWineType() {
		return wineType;
	}
	
	public List<Note> getNotes(){
		return notes;
	}
	
	public void setNotes(List<Note> notes){
		this.notes = notes;
	}
	
	public void addNote(Note note){
		if(note.getContent().length()<40){
			System.err.println("Length must be at least 40 characters");
		} else if (note.getContent().length()>1024){
			System.err.println("Note must be less than 1024 characters");
		} else
			notes.add(note);		
	}
	
	public void deleteNote(Note note){
		notes.remove(note);
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public void setGrape(String grape) {
		this.grape = grape;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public void setWineVariety(WineVariety wineVariety) {
		this.wineVariety = wineVariety;
	}

	public void setWineType(WineType wineType) {
		this.wineType = wineType;
	}

	@Override
	public String toString(){
		String out = "WineVariety: "+wineVariety+"\nLabel Name: "+labelName+
				"\nGrape Type: "+grape+"\nRegion: "+region+"\nCountry:"+country+
				"\nMaker: "+maker+"\nYear produced: " +year+"\nWineID: "+ID;
		return out;
	}
}
