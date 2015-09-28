package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;
import java.util.List;

public class AR extends MonthlySelection {
	private List<Wine> msRedWines = new ArrayList<Wine>();
	public AR() {
		super.monthlyselectiontype = MonthlySelectionType.AR;
	}
	@Override
	void addWine(Wine wine) {
		if(!(wine.getWineVariety()==WineVariety.RED)){
			System.out.println("You can only add Red WINES!");
		} else {
			msRedWines.add(wine);
		}
	}
	
	
}
