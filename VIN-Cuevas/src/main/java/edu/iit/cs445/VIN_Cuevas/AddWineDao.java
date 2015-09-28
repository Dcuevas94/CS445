package edu.iit.cs445.VIN_Cuevas;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AddWineDao {
	private Map<String, Wine> wines;
	
	public AddWineDao(){
		wines = new ConcurrentHashMap<String, Wine>();
	}
	
	public Collection<Wine> getWines(){
		return(wines.values());
	}
	
	public Wine getWine(String id){
		return(wines.get(id));
	}
	
	public Wine addWine(Wine wine){
		String wineID = Integer.toString(wine.getID());
		wines.put(wineID, wine);
		return wine;
	}
}
