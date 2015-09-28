package edu.iit.cs445.VIN_Cuevas;

import java.time.Year;

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
	
	public Wine(){
		this.labelName = "The Mission";
		this.grape = "Cabernet Sauvignon";
		this.region = "Napa";
		this.country = "USA";
		this.maker = "Sterling";
		this.year = Year.parse("2011");
		this.wineType = WineType.TABLE;
		this.wineVariety = WineVariety.RED;
		this.ID = IdGenerator.newIDwineOnly();
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
		this.ID = IdGenerator.newIDwineOnly();
	}
	
	public void addRating(int rate){
		numberOfRatings++;
		rating = rating*((float)(numberOfRatings - 1)/numberOfRatings)+ (float)rate/numberOfRatings;
	}
	

	public boolean isMatch(String kw){
		if(isMatchVariety(kw) || isMatchType(kw) || isMatchLabel(kw) || isMatchGrape(kw) || isMatchRegion(kw) || isMatchCountry(kw) || isMatchMaker(kw) || isMatchYear(kw)) {
			return true;
		} else
			return false;
	}
	
	public boolean isMatchVariety(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.wineVariety.name().matches(regex);
	}
	
	public boolean isMatchType(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.wineType.name().matches(regex);
	}
	
	public boolean isMatchLabel(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.labelName.matches(regex);
	}
	
	public boolean isMatchGrape(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.grape.matches(regex);
	}
	
	public boolean isMatchRegion(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.region.matches(regex);
	}
	
	public boolean isMatchCountry(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.country.matches(regex);
	}
	
	public boolean isMatchMaker(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.maker.matches(regex);
	}
	
	public boolean isMatchYear(String kw){
		String regex = "(?i).*" + kw +".*";
		return this.year.toString().matches(regex);
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
