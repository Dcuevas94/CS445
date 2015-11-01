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

@Path("/sub")
public class AddSubscriber {


	@Context AddSubscriberDao sDao;
	
	@GET //all subscribers
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Subscriber> getSubscriber(){
		return(sDao.getSubsciber());
	}

	@POST //adds new subscriber
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
	@Produces(MediaType.APPLICATION_JSON)
	public Subscriber addSubscriber(Subscriber subscriber){
		System.out.println(subscriber.getName());
		return(sDao.addSubscriber(subscriber));
	}
	
	@Path("/{uid}")	//gets individual subscriber
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Subscriber getSubscriber(@PathParam("uid") String id) {
		return(sDao.getSubsciber(id));
	}
	
	@Path("/{uid}/shipments")	//gets shipments of specific subscriber
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shipments> getShipments(@PathParam("uid") String id){
		return(sDao.getShipments(id));
	}
	
	@Path("/{uid}/shipments")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
	@Produces(MediaType.APPLICATION_JSON)
 	public Shipments addShipment(@PathParam("uid") String id, Shipments shipment){
		return(sDao.addShipment(id, shipment));
	}
}
