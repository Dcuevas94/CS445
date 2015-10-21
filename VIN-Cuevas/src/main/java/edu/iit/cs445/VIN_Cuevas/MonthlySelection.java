package edu.iit.cs445.VIN_Cuevas;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public abstract class MonthlySelection {
	protected MonthlySelectionType monthlyselectiontype;
	private YearMonth yearmonth;
	private List<Wine> msWines = new ArrayList<Wine>(6);
	private int selectionID;

	public MonthlySelection(){
		this.yearmonth = YearMonth.now().plusMonths(1);
		this.selectionID = IdGenerator.newIDms();
	}
	
	public MonthlySelection(String yearmonth){
		this.yearmonth = YearMonth.parse(yearmonth);
		this.selectionID = IdGenerator.newIDms();
	}
	
	abstract void addWine(Wine w); //Implemented in AR, AW, RW
	
	public YearMonth getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(YearMonth yearmonth) {
		this.yearmonth = yearmonth;
	}
	
	public int getSelectionID() {
		return selectionID;
	}

	public List<Wine> getMsWines() {
		return msWines;
	}

	public void setMsWines(List<Wine> msWines) {
		this.msWines = msWines;
	}
	
//	public boolean isMatch(String kw){
//		Iterator<Wine> eachWine = this.msWines.iterator();
//		while(eachWine.hasNext()){
//			Wine w = eachWine.next();
//			if(w.isMatch(kw))
//				return true;
//		}
//		return false;
//	}
}