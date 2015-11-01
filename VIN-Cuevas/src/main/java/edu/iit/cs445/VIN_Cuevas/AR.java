package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;

public class AR extends MonthlySelection {
	//private List<Wine> msRedWines = new ArrayList<Wine>();
	
	public AR() {
		super();
		super.msWines = new ArrayList<Wine>();
		super.monthlyselectiontype = MonthlySelectionType.AR;
	}
	
	public AR(String yearMonth){
		super(yearMonth);
		super.msWines = new ArrayList<Wine>();
		super.monthlyselectiontype = MonthlySelectionType.AR;
	}
	
	@Override
	void addWine(Wine wine) {
		if(!(wine.getWineVariety()==WineVariety.RED) && msWines.size()>6){
			System.out.println("You can only add Red WINES!");
		} else {
			this.getMsWines().add(wine);
		}
	}
	
	
}
