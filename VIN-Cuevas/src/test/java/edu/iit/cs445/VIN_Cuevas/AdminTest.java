package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminTest {

	private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    @Test
    public void test_admin_default(){
    	Admin a = new Admin();
    	assertEquals(a.getName(), "John Admin");
    	assertEquals(a.getEmail(), "jAdams@gmail.com");
    	assertNotNull(a.getID());
    }
    
    @Test
    public void test_admin_nonDefault(){
    	Admin a = new Admin("Joe Admin", "joe@gmail.com");
    	assertEquals(a.getName(), "Joe Admin");
    	assertEquals(a.getEmail(), "joe@gmail.com");
    	assertNotNull(a.getID());
    }
    
    @Test
    public void test_admin_setting_properties(){
    	Admin a = new Admin();
    	assertEquals(35, a.getID());
    	a.setName("Bob Admin");
    	a.setEmail("bobadmin@gmail.com");
    	a.setID(55);
    	assertEquals(a.getName(), "Bob Admin");
    	assertEquals(a.getEmail(), "bobadmin@gmail.com");
    	assertNotNull(a.getID());
    }
    
    @Test
    public void test_admin_toString(){
    	Admin a = new Admin();
    	String output = "Admin name: "+a.getName()+"\nID: "+a.getID()+"\nEmail: "+a.getEmail()+"\n";
		assertEquals(a.toString(), output);
    }

}
