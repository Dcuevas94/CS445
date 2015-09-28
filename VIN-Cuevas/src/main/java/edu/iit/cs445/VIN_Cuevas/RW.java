package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;
import java.util.List;

public class RW extends MonthlySelection {
	private List<Wine> msMixWines = new ArrayList<Wine>();
	
	public RW() {
		super.monthlyselectiontype = MonthlySelectionType.RW;
	}
	
	@Override
	void addWine(Wine wine) {
		msMixWines.add(wine);
	}
	
}
