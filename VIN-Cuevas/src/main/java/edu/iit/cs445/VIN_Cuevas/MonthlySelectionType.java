package edu.iit.cs445.VIN_Cuevas;

public enum MonthlySelectionType {

	AW("All whites"), AR("All reds"), RW("Reds and Whites");

	private String description;
	
	private MonthlySelectionType(String ms) {
		this.description = ms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
