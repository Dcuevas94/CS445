package edu.iit.cs445.VIN_Cuevas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AddMonthlySelectionDao {
	private Map<String, MonthlySelection> monthlyselections;
	private List<Wine> msWineList = new ArrayList<Wine>();
	MonthlySelection ms;
		
	public AddMonthlySelectionDao() {
		monthlyselections = new ConcurrentHashMap<String, MonthlySelection>();
	}
	
	public Collection<MonthlySelection> getMonthlySelections(){
		return(monthlyselections.values());
	}
	
	public MonthlySelection getMonthlySelection(String selectionID){
		return(monthlyselections.get(selectionID));
	}
	
	public MonthlySelection addMonthlySelection(MonthlySelection monthlyselection){
		String msID = Integer.toString(monthlyselection.getSelectionID());
		monthlyselections.put(msID, monthlyselection);
		msWineList.add((Wine) monthlyselection.getMsWines());
//		if(monthlyselection.monthlyselectiontype == MonthlySelectionType.AR){
//			AR arWines = new AR();
//			arWines.addWine((Wine) msWineList);
//		}
		return monthlyselection;
	}
}
