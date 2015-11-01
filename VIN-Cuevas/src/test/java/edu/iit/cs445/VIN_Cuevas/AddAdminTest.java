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

@SuppressWarnings("unused")
public class AddAdminTest extends JerseyTest{
	
	private int admin1_id;
	private int admin2_id;
	
	protected Application configure(){
		return new AppApplication();
	}
	
	protected Response AddAdmin(String name, String email){
		Admin admin1 = new Admin();
		admin1.setName(name);
		admin1.setEmail(email);
		Entity<Admin> adminEntity = Entity.entity(admin1, MediaType.APPLICATION_JSON);
		return(target("admin").request().post(adminEntity));
	}
	
	@Before
	public void setupAdmins(){
		admin1_id = AddAdmin("Carol", "carol@gmail.com").readEntity(Admin.class).getID();
		admin2_id = AddAdmin("Rick", "rick@gmail.com").readEntity(Admin.class).getID();
	}
	
	@Test
	public void testAddAdmin(){
		Response response = AddAdmin("J. Cole", "jcole@gmail.com");
		assertEquals(200, response.getStatus());
		Admin adminresponse = response.readEntity(Admin.class);
		assertNotNull(adminresponse.getID());
		assertEquals("J. Cole", adminresponse.getName());
		assertEquals("jcole@gmail.com", adminresponse.getEmail());
		assertNotNull(adminresponse.getID());
	}

	@Test
	public void test_admin1_adminByID(){
		Admin response = target("admin").path(Integer.toString(admin1_id)).request().get(Admin.class);
		assertNotNull(response);
		Admin responseAdmin = new Admin(response.getName(), response.getEmail());
		assertEquals("Carol", responseAdmin.getName());
		assertEquals("carol@gmail.com", responseAdmin.getEmail());
		assertNotNull(responseAdmin.getID());
	}
	
	@Test
	public void test_admin2_adminByID(){
		Admin response = target("admin").path(Integer.toString(admin2_id)).request().get(Admin.class);
		assertNotNull(response);
		Admin responseAdmin = new Admin(response.getName(), response.getEmail());
		assertEquals("Rick", responseAdmin.getName());
		assertEquals("rick@gmail.com", responseAdmin.getEmail());
		assertNotNull(responseAdmin.getID());
	}
	
	@Test
	public void test_get_admins(){
		Collection<Admin> response = target("admin").request().get(new GenericType<Collection<Admin>>() {} );
		assertEquals(2,  response.size());
	}
}