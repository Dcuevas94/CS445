package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.*;

import java.time.Year;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WineTest {

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
	public void test_wine_default() {
		Wine w = new Wine();
		assertEquals(w.getLabelName(), "The Mission");
		assertEquals(w.getGrape(), "Cabernet Sauvignon");
		assertEquals(w.getRegion(), "Napa");
		assertEquals(w.getCountry(), "USA");
		assertEquals(w.getMaker(), "Sterling");
		assertEquals(w.getYear(), "2011");
		assertEquals(w.getWineType(), WineType.TABLE);
		assertEquals(w.getWineVariety(), WineVariety.RED);
		assertNotNull(w.getID());
		w.addRating(5);
		w.addRating(5);
		assertEquals(w.getRating(), 5, 0.0);
		assertEquals(w.getNumberOfRatings(), 2);
		assertEquals(w.isMatch(w.getLabelName()), true);
		assertEquals(w.isMatch("hello"), false);
		assertEquals(w.isMatch(w.getCountry()), true);
		assertEquals(w.isMatch(w.getGrape()), true);
		assertEquals(w.isMatch(w.getMaker()), true);
		assertEquals(w.isMatch(w.getRegion()), true);
		assertEquals(w.isMatch(w.getYear()), true);
		assertEquals(w.isMatchType(w.getWineType().toString()), true);
		assertEquals(w.isMatch(w.getWineVariety().toString()), true);
		assertEquals(w.isMatch("Napa"), true);
	}
	
	@Test
	public void test_nonDefaultWine(){
		Wine w2 = new Wine(WineVariety.RED, WineType.SWEET, "The Beast", "black", "Hell", "Tarturus", "Satan", Year.parse("1666"));
		assertEquals(w2.getLabelName(), "The Beast");
		assertEquals(w2.getGrape(), "black");
		assertEquals(w2.getRegion(), "Hell");
		assertEquals(w2.getCountry(), "Tarturus");
		assertEquals(w2.getMaker(), "Satan");
		assertEquals(w2.getYear(), "1666");
		assertEquals(w2.getWineType(), WineType.SWEET);
		assertEquals(w2.getWineVariety(), WineVariety.RED);
		assertNotNull(w2.getID());
		w2.addRating(5);
		w2.addRating(10);
		assertEquals(w2.getRating(), 7.5, 0.0);
		assertEquals(w2.getNumberOfRatings(), 2);
		assertEquals(w2.isMatch(w2.getLabelName()), true);
		assertEquals(w2.isMatch("hello"), false);
		assertEquals(w2.isMatch(w2.getCountry()), true);
		assertEquals(w2.isMatch(w2.getGrape()), true);
		assertEquals(w2.isMatch(w2.getMaker()), true);
		assertEquals(w2.isMatch(w2.getRegion()), true);
		assertEquals(w2.isMatch(w2.getYear()), true);
		assertEquals(w2.isMatchType(w2.getWineType().toString()), true);
		assertEquals(w2.isMatch(w2.getWineVariety().toString()), true);
		assertEquals(w2.isMatch("Napa"), false);
		assertEquals(w2.isMatch("hell"), true);
	}
	
	@Test
	public void test_wine_toString(){
		Wine w = new Wine();
		String out = "WineVariety: "+w.getWineVariety()+"\nLabel Name: "+w.getLabelName()+
				"\nGrape Type: "+w.getGrape()+"\nRegion: "+w.getRegion()+"\nCountry:"+w.getCountry()+
				"\nMaker: "+w.getMaker()+"\nYear produced: " +w.getYear()+"\nWineID: "+w.getID();
		assertEquals(w.toString(), out);
	}
	
	@Test
	public void test_settingValues(){
		Wine w = new Wine();
		w.setLabelName("Blue Sky");
		w.setGrape("blue");
		w.setRegion("Sea");
		w.setCountry("Kanto");
		w.setMaker("Mr. Blue");
		w.setNumberOfRatings(10);
		w.setRating((float) 6.65);
		w.setID(810);
		w.setYear(Year.parse("2001"));
		w.setWineType(WineType.SPARKLING);
		w.setWineVariety(WineVariety.WHITE);
		assertEquals(w.getLabelName(), "Blue Sky");
		assertEquals(w.getGrape(), "blue");
		assertEquals(w.getRegion(), "Sea");
		assertEquals(w.getCountry(), "Kanto");
		assertEquals(w.getMaker(), "Mr. Blue");
		assertEquals(w.getNumberOfRatings(), 10);
		assertEquals(w.getRating(), 6.65, 0.01); //third option is the delta or difference from actual to expected
		assertEquals(w.getID(), 810);
		assertEquals(w.getYear(), "2001");
		assertEquals(w.getWineType(), WineType.SPARKLING);
		assertEquals(w.getWineVariety(), WineVariety.WHITE);
		
	}

}
