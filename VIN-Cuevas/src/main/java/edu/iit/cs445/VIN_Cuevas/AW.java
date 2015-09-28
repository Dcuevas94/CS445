package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;
import java.util.List;


public class AW extends MonthlySelection {
	private List<Wine> msWhiteWines = new ArrayList<Wine>();
	
	public AW() {
		super.monthlyselectiontype = MonthlySelectionType.AW;
	}

	@Override
	public void addWine(Wine wine) {
		if(!(wine.getWineVariety()==WineVariety.WHITE)){
			System.out.println("You can only add white wines!");
		} else {
			msWhiteWines.add(wine);
		}
	}
}