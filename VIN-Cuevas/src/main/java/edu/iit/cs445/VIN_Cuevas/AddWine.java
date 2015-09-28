package edu.iit.cs445.VIN_Cuevas;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/wines")
public class AddWine {
	@Context AddWineDao wDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Wine> getWines(){
		return(wDao.getWines());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Wine addWine(Wine wine){
		return(wDao.addWine(wine));
	}
	
	@Path("/{wid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Wine getWine(@PathParam("wid") String id){
		return(wDao.getWine(id));
	}
}