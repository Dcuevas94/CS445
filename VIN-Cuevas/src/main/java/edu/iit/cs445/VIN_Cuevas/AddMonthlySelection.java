package edu.iit.cs445.VIN_Cuevas;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/admin/monthly_selection")
public class AddMonthlySelection {
	@Context AddMonthlySelectionDao msDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MonthlySelection> getMonthlySelections(){
		return(msDao.getMonthlySelections());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MonthlySelection addMonthlySelection(MonthlySelection monthlyselection){
		
		return(msDao.addMonthlySelection(monthlyselection));
	}
}
