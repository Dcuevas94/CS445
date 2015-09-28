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

@Path("/admin")
public class AddAdmin {
	@Context AddAdminDao aDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Admin> getAdmin(){
		return(aDao.getAdmin());
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
	@Produces(MediaType.APPLICATION_JSON)
	public Admin addAdmin(Admin admin){
		System.out.println(admin.getName());
		return(aDao.addAdmin(admin));
	}

	@Path("/{aid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Admin getAdmin(@PathParam("aid") String id){
		return(aDao.getAdmin(id));
	}
	
	@GET
	@Path("/revenue")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRevenue(){
		return getRevenue();
	}
}
