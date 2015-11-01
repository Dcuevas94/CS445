package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;


public class AW extends MonthlySelection {
	//private List<Wine> msWhiteWines = new ArrayList<Wine>();
	
	public AW() {
		super();
		super.msWines = new ArrayList<Wine>();
		super.monthlyselectiontype = MonthlySelectionType.AW;
	}
	
	public AW(String yearMonth){
		super(yearMonth);
		super.msWines = new ArrayList<Wine>();
		super.monthlyselectiontype = MonthlySelectionType.AW;
	}

	@Override
	public void addWine(Wine wine) {
		if(!(wine.getWineVariety()==WineVariety.WHITE) && getMsWines().size()>6){
			System.out.println("You can only add white wines!");
		} else {
			this.getMsWines().add(wine);
		}
	}
}