package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.fail;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Year;
import java.time.YearMonth;
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
public class AddWineTest extends JerseyTest{

	private int wine1_id;
	private int wine2_id;
	
	protected Application configure(){
		return new AppApplication();
	}
	
	protected Response AddWine(WineVariety winevariety, WineType winetype, String labelname, String grape, String region, String country, String maker, Year year){
		Wine wine1 = new Wine();
		wine1.setWineVariety(winevariety);
		wine1.setWineType(winetype);
		wine1.setLabelName(labelname);
		wine1.setGrape(grape);
		wine1.setRegion(region);
		wine1.setCountry(country);
		wine1.setMaker(maker);
		wine1.setYear(year);
		Entity<Wine> wineEntity = Entity.entity(wine1, MediaType.APPLICATION_JSON);
		return(target("wines").request().post(wineEntity));
	}
	
	@Before
	public void setupWines(){
		wine1_id = AddWine(WineVariety.RED, WineType.SPARKLING, "cali", "red", "West", "USA", "Johnson", Year.parse("2011")).readEntity(Wine.class).getID();
		wine2_id = AddWine(WineVariety.WHITE, WineType.TABLE, "blue", "red", "East", "USA", "Thompson", Year.parse("2008")).readEntity(Wine.class).getID();
	}
	
	@Test
	public void testAddWines(){
		Response response = AddWine(WineVariety.WHITE, WineType.TABLE, "wine1", "grape1", "region1", "USA", "maker1", Year.parse("2011"));
		assertEquals(200, response.getStatus());
		Wine wineresponse = response.readEntity(Wine.class);
		assertNotNull(wineresponse);
		assertEquals(WineVariety.WHITE, wineresponse.getWineVariety());
		assertEquals(WineType.TABLE, wineresponse.getWineType());
		assertEquals("wine1", wineresponse.getLabelName());
		assertEquals("grape1", wineresponse.getGrape());
		assertEquals("region1", wineresponse.getRegion());
		assertEquals("USA", wineresponse.getCountry());
		assertEquals("maker1", wineresponse.getMaker());
		assertEquals("2011", wineresponse.getYear());
	}

	@Test 
	public void test_wine1_wineByID(){
		Wine response = target("wines").path(Integer.toString(wine1_id)).request().get(Wine.class);
		assertNotNull(response);
		Wine responseWine = new Wine(response.getWineVariety(), response.getWineType(), response.getLabelName(), response.getGrape(), response.getRegion(), response.getCountry(), response.getMaker(), Year.parse(response.getYear()));
		assertEquals(WineVariety.RED, responseWine.getWineVariety());
		assertEquals(WineType.SPARKLING, responseWine.getWineType());
		assertEquals("cali", responseWine.getLabelName());
		assertEquals("red", responseWine.getGrape());
		assertEquals("West", responseWine.getRegion());
		assertEquals("USA", responseWine.getCountry());
		assertEquals("Johnson", responseWine.getMaker());
		assertEquals("2011", responseWine.getYear());
		responseWine.getNumberOfRatings();
		responseWine.getRating();
	}
	
	@Test 
	public void test_wine2_wineByID(){
		Wine response = target("wines").path(Integer.toString(wine2_id)).request().get(Wine.class);
		assertNotNull(response);
		Wine responseWine = new Wine(response.getWineVariety(), response.getWineType(), response.getLabelName(), response.getGrape(), response.getRegion(), response.getCountry(), response.getMaker(), Year.parse(response.getYear()));
		assertEquals(WineVariety.WHITE, responseWine.getWineVariety());
		assertEquals(WineType.TABLE, responseWine.getWineType());
		assertEquals("blue", responseWine.getLabelName());
		assertEquals("red", responseWine.getGrape());
		assertEquals("East", responseWine.getRegion());
		assertEquals("USA", responseWine.getCountry());
		assertEquals("Thompson", responseWine.getMaker());
		assertEquals("2011", responseWine.getYear());
		responseWine.getNumberOfRatings();
		responseWine.getRating();
	}
	
	@Test
	public void test_get_wines(){
		Collection<Wine> response = target("wines").request().get(new GenericType<Collection<Wine>>() {} );
		assertEquals(2, response.size());
	}
}