package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubscriberTest {


    private HttpServer server;
    @SuppressWarnings("unused")
	private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());
        target = c.target(Main.BASE_URI);
    }

    @SuppressWarnings("deprecation")
	@After
    public void tearDown() throws Exception {
        server.stop();
    }

	
	@Test
	public void test_search_match_name() {
		Subscriber s = new Subscriber();
		assertTrue(s.isMatch("default Doe"));
	}

	@Test
	public void test_search_fails() {
		Subscriber s = new Subscriber();
		assertFalse(s.isMatch("smith"));
	}

	@Test
	public void test_search_match_email() {
		Subscriber s = new Subscriber();
		assertTrue(s.isMatch("bob@gmail.com"));
	}

	@Test
	public void test_search_match_phone_partial() {
		Subscriber s = new Subscriber();
		assertTrue(s.isMatch("123456789"));
	}

	@Test
	public void test_formatted_phone_number_matches() {
		Subscriber s = new Subscriber();
		assertTrue(s.isMatch("123456789"));
		assertFalse(s.isMatch("123456799"));
	}

	@Test
	public void test_search_match_phone_full() {
		Subscriber s = new Subscriber("John Doe", "johndoe@example.com",
				"(123) 456-7890", new Address());
		assertTrue(s.isMatch("1234567890"));
	}

	@Test
	public void test_default_monthly_preference() {
		Subscriber s = new Subscriber();
		assertEquals(MonthlySelectionType.RW, s.getPreference());
	}

	@Test
	public void test_changing_the_monthly_preference() {
		Subscriber s = new Subscriber();
		s.setPreference(MonthlySelectionType.AR);
		assertEquals(MonthlySelectionType.AR, s.getPreference());
		assertNull(s.getTwitter());
	}
	
	@Test
	public void test_base_case(){
		Subscriber s = new Subscriber();
		assertEquals(s.getName(), "default Doe");
		assertEquals(s.getName(), new Subscriber().getName());
		assertEquals(s.getID(), s.getID());
		assertEquals(s.getPreference(), MonthlySelectionType.RW);
		assertEquals(s.getEmail(), "bob@gmail.com");
		assertEquals(s.getPhone(), "123456789");
		assertEquals(s.getAddress().getCity(), "Chicago");
		assertEquals(s.getAddress().getState(), "IL");
		assertEquals(s.getAddress().getStreet(), "555 State St.");
		assertEquals(s.getAddress().getZip(), "60609");
		assertNull(s.getFacebook());
		assertNull(s.getTwitter());
	}
	
	@Test
	public void test_nondefault_subscriber(){
		Subscriber s = new Subscriber("dan", "dan@gmail.com", "2345678", new Address());
		assertEquals(s.getName(), "dan");
		assertEquals(s.getEmail(), "dan@gmail.com");
		assertEquals(s.getPhone(), "2345678");
		assertEquals(s.getAddress().getStreet(), "555 State St.");
		assertEquals(s.getAddress().getCity(), "Chicago");
		assertEquals(s.getAddress().getState(), "IL");
		assertEquals(s.getAddress().getZip(), "60609");
		assertNotNull(s.getAddress());
		assertNull(s.getFacebook());
		assertNull(s.getTwitter());
	}
	
	@Test
	public void test_nondefault_subscriberWithAddress(){
		Subscriber s = new Subscriber("dan", "dan@gmail.com", "123456789", new Address("666 state st.", "Chicago", "IL", "60608"));
		assertEquals(s.getName(), "dan");
		assertEquals(s.getEmail(), "dan@gmail.com");
		assertEquals(s.getPhone(), "123456789");
		assertEquals(s.getAddress().getStreet(), "666 state st.");
		assertEquals(s.getAddress().getCity(), "Chicago");
		assertEquals(s.getAddress().getState(), "IL");
		assertEquals(s.getAddress().getZip(), "60608");
		assertNotNull(s.getAddress());
		assertNull(s.getFacebook());
		assertNull(s.getTwitter());
	}
	
	@Test
	public void test_nondefault_subscriberEmail(){
		Subscriber s = new Subscriber("dan", "dan@gmail.com", "2345678", new Address());
		assertEquals(s.getEmail(), "dan@gmail.com");
	}
	
	@Test
	public void test_nondefault_subscriberPhone(){
		Subscriber s = new Subscriber("dan", "dan@gmail.com", "2345678", new Address());
		assertEquals(s.getPhone(), "2345678");
	}
	
	@Test
	public void test_nondefault_subscriberAddress(){
		Subscriber s = new Subscriber("dan", "dan@gmail.com", "2345678", new Address());
		assertNotNull(s.getAddress());
	}
	
	@Test
	public void test_FacebookTwitter_Subscriber(){
		Subscriber s = new Subscriber("dan", "dan@gmail.com", "123456789", new Address("333 State St.", "Chicago", "IL", "60610"), "dan@facebook.com", "dan@twitter.com");
		assertEquals(s.getName(), "dan");
		assertEquals(s.getEmail(), "dan@gmail.com");
		assertEquals(s.getPhone(), "123456789");
		assertEquals(s.getAddress().getCity(), "Chicago");
		assertEquals(s.getAddress().getState(), "IL");
		assertEquals(s.getAddress().getStreet(), "333 State St.");
		assertEquals(s.getAddress().getZip(), "60610");
		assertEquals(s.getFacebook(), "dan@facebook.com");
		assertEquals(s.getTwitter(), "dan@twitter.com");
	}
	
	@Test
	public void test_setting_address_defaultsubscriber(){
		Subscriber s = new Subscriber();
		assertEquals(s.getName(), "default Doe");
		assertEquals(s.getName(), new Subscriber().getName());
		assertEquals(s.getID(), s.getID());
		assertEquals(s.getPreference(), MonthlySelectionType.RW);
		assertEquals(s.getEmail(), "bob@gmail.com");
		assertEquals(s.getPhone(), "123456789");
		assertEquals(s.getAddress().getCity(), "Chicago");
		assertEquals(s.getAddress().getState(), "IL");
		assertEquals(s.getAddress().getStreet(), "555 State St.");
		assertEquals(s.getAddress().getZip(), "60609");
		assertNull(s.getFacebook());
		assertNull(s.getTwitter());
		s.setAddress(new Address("1428 Elm St.", "Springwood", "Nightmare", "66606"));
		assertEquals(s.getAddress().getCity(), "Springwood");
		assertEquals(s.getAddress().getState(), "Nightmare");
		assertEquals(s.getAddress().getStreet(), "1428 Elm St.");
		assertEquals(s.getAddress().getZip(), "66606");
		s.getAddress().setCity("Muahaha");;
		s.getAddress().setState("Death");
		s.getAddress().setStreet("666 Halloween St.");
		s.getAddress().setZip("666");
		assertEquals(s.getAddress().getCity(), "Muahaha");
		assertEquals(s.getAddress().getState(), "Death");
		assertEquals(s.getAddress().getStreet(), "666 Halloween St.");
		assertEquals(s.getAddress().getZip(), "666");
	}
	
	@Test
	public void test_subscriber_update(){
		Subscriber s = new Subscriber();
		s.updateInfo("Link", "link@gmail.com", "67890", new Address("blah", "blah", "blah", "blah"));
		assertEquals(s.getName(), "Link");
		assertEquals(s.getEmail(), "link@gmail.com");
		assertEquals(s.getPhone(), "67890");
		assertEquals(s.getAddress().getCity(), "blah");
		assertEquals(s.getAddress().getState(), "blah");
		assertEquals(s.getAddress().getStreet(), "blah");
		assertEquals(s.getAddress().getZip(), "blah");
		s.setName("Steve");
		s.setEmail("steve@gmail.com");
		s.setPhone("555-555");
		s.setTwitter("steve@twitter.com");
		s.setFacebook("steve@facebook.com");
		s.setID(666);
		assertEquals(s.getName(), "Steve");
		assertEquals(s.getEmail(), "steve@gmail.com");
		assertEquals(s.getPhone(), "555-555");
		assertEquals(s.getFacebook(), "steve@facebook.com");
		assertEquals(s.getTwitter(), "steve@twitter.com");
	} 
	
	@Test
	public void test_addWines(){
		Subscriber s = new Subscriber();
		Wine wine = new Wine();
		s.addWines(wine);
	}
	
	@Test
	public void test_toString(){
		Subscriber s = new Subscriber("dan", "dan@g.com", "123456789", new Address("street", "city", "state", "010101"), "dan@fb.com", "dan@tw.com");
		String output = "The name of the Subscriber is " +s.getName()+ " The email is " +s.getEmail()+
    			" The phone number is " +s.getPhone()+" the ID is: " +s.getID()+" The address is "  +s.getAddress()+
    			" The monthly selection is " +s.getPreference();
		assertEquals(output, s.toString());
	}
	
	@Test
	public void test_address(){
		Subscriber sub1 = new Subscriber();
		Subscriber sub2 = new Subscriber();
		assertTrue(sub1.getAddress().isMatch(sub2.getAddress()));
		sub1.getAddress().setCity("Chi-city");
		assertFalse(sub1.getAddress().isMatch(sub2.getAddress()));
		sub1.getAddress().setState("IL");
		assertFalse(sub1.getAddress().isMatch(sub2.getAddress()));
		sub1.getAddress().setStreet("Yeet street");
		assertFalse(sub1.getAddress().isMatch(sub2.getAddress()));
		sub1.getAddress().setZip("60666");
		assertFalse(sub1.getAddress().isMatch(sub2.getAddress()));
	}
} 
