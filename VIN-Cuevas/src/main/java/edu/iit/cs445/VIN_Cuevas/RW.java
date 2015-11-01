package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;

public class RW extends MonthlySelection {
	
	public RW() {
		super();
		super.msWines = new ArrayList<Wine>();
		super.monthlyselectiontype = MonthlySelectionType.RW;
	}
	
	public RW(String yearMonth){
		super(yearMonth);
		super.msWines = new ArrayList<Wine>();
		super.monthlyselectiontype = MonthlySelectionType.RW;
	}
	
	@Override
	void addWine(Wine wine) {
		int red = 0;
		int white = 0;
		if(this.getMsWines().size()<6){
			for(Wine wne : this.getMsWines()){
				if(wne.getWineVariety().equals(WineVariety.RED)) red++;
				if(wne.getWineVariety().equals(WineVariety.WHITE)) white++;
			}
			if(wine.getWineVariety().equals(WineVariety.RED) && red<3){
				this.getMsWines().add(wine);
			}
			if(wine.getWineVariety().equals(WineVariety.WHITE) && white<3){
				this.getMsWines().add(wine);
			}
		}
		//msMixWines.add(wine);
	}
	
}
