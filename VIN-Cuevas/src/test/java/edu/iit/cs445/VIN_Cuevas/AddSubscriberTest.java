package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.fail;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;



public class AddSubscriberTest extends JerseyTest {

	private int sub1_id;
	private int sub2_id;
	
	protected Application configure(){
		return new AppApplication();
	}
	
	protected Response AddSubscriber(String name, String email, String phone, Address address){
		Subscriber sub1 = new Subscriber();
		sub1.setName(name);
		sub1.setEmail(email);
		sub1.setPhone(phone);
		sub1.setAddress(address);
		Entity<Subscriber> subscriberEntity = Entity.entity(sub1, MediaType.APPLICATION_JSON);
		return(target("sub").request().post(subscriberEntity));
	}
	
	@Before
	public void setupSubscribers(){
		sub1_id = AddSubscriber("Tom", "tom@gmail.com", "123456789", new Address("123 S. LaSalle", "Chicago", "IL", "60609")).readEntity(Subscriber.class).getID();
		sub2_id = AddSubscriber("Bob", "bob@gmail.com", "123123", new Address("324 S. State", "Chicago", "IL", "60632")).readEntity(Subscriber.class).getID();
	}
	
	
	@Test
	public void testAddSubscriber(){
		Response response = AddSubscriber("Daniel", "dcuevas@hawk.iit.edu", "1234", new Address("123 S. State", "Chicago", "IL", "60609"));
		assertEquals(200, response.getStatus());
		Subscriber responseSub = response.readEntity(Subscriber.class);
		assertNotNull(responseSub.getID());
		assertEquals("Daniel", responseSub.getName());
		assertEquals("dcuevas@hawk.iit.edu", responseSub.getEmail());
		assertEquals("1234", responseSub.getPhone());
		assertEquals("123 S. State", responseSub.getAddress().getStreet());
		assertEquals("Chicago", responseSub.getAddress().getCity());
		assertEquals("IL", responseSub.getAddress().getState());
		assertEquals("60609", responseSub.getAddress().getZip());
	}
	
	@Test
	public void test_sub1_SubscriberByID(){
//		sub1_id = AddSubscriber("Tom", "tom@gmail.com", "123456789", new Address("123 S. LaSalle", "Chicago", "IL", "60609")).readEntity(Subscriber.class).getID();
//		sub2_id = AddSubscriber("Bob", "bob@gmail.com", "123123", new Address("324 S. State", "Chicago", "IL", "60632")).readEntity(Subscriber.class).getID();
		Subscriber response = target ("sub").path(Integer.toString(sub1_id)).request().get(Subscriber.class);
		assertNotNull(response);
		Subscriber responseSub = new Subscriber(response.getName(), response.getEmail(), response.getPhone(), response.getAddress(), response.getFacebook(), response.getTwitter());
		assertEquals("Tom", responseSub.getName());
		assertEquals("tom@gmail.com", responseSub.getEmail());
		assertEquals("123456789", responseSub.getPhone());
		assertEquals("123 S. LaSalle", responseSub.getAddress().getStreet());
		assertEquals("Chicago", responseSub.getAddress().getCity());
		assertEquals("IL", responseSub.getAddress().getState());
		assertEquals("60609", responseSub.getAddress().getZip());
		assertNotNull(responseSub.getID());
	}
	
	@Test
	public void test_sub2_SubscriberByID(){
		Subscriber response = target ("sub").path(Integer.toString(sub2_id)).request().get(Subscriber.class);
		assertNotNull(response);
		Subscriber responseSub = new Subscriber(response.getName(), response.getEmail(), response.getPhone(), response.getAddress(), response.getFacebook(), response.getTwitter());
		assertEquals("Bob", responseSub.getName());
		assertEquals("bob@gmail.com", responseSub.getEmail());
		assertEquals("123123", responseSub.getPhone());
		assertEquals("324 S. State", responseSub.getAddress().getStreet());
		assertEquals("Chicago", responseSub.getAddress().getCity());
		assertEquals("IL", responseSub.getAddress().getState());
		assertEquals("60632", responseSub.getAddress().getZip());
		assertNotNull(responseSub.getID());
	}
	
	@Test
	public void test_get_subscribers(){
		Collection<Subscriber> response = target("sub").request().get(new GenericType<Collection<Subscriber>>(){} ); //getting all them subscribers tho
		assertEquals(2,  response.size());
	}
}