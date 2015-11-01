package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.*;

import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.message.internal.MsgTraceEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")
public class ARAWRWMonthlySelectionTest {
	private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());
        target = c.target(Main.BASE_URI);
    }

    @SuppressWarnings("deprecation")
	@After
    public void tearDown() throws Exception {
        server.stop();
    }
    
	@Test
	public void test_RW_base(){
		RW rwNew = new RW();
		assertNotNull(rwNew.getSelectionID());
		Wine wine0 = new Wine();
		rwNew.addWine(wine0);
		assertNotNull(rwNew.getMsWines());
		assertEquals(rwNew.getYearmonth(), YearMonth.parse("2015-11"));
	}
	
	
	@Test
	public void test_AR_base(){
		AR ar = new AR();
		assertNotNull(ar.getSelectionID());
		Wine wine1 = new Wine();
		wine1.setWineVariety(WineVariety.RED);
		ar.addWine(wine1);
		assertNotNull(ar.getMsWines());
		assertEquals(YearMonth.parse("2015-11"), ar.getYearmonth());
		Wine wine2 = new Wine();
		wine2.setWineVariety(WineVariety.WHITE);
		ar.addWine(wine2);
	}
	
	@Test
	public void test_allWhite_base(){
		AW aw = new AW();
		assertNotNull(aw.getSelectionID());
		Wine wine3 = new Wine();
		aw.addWine(wine3);
		assertNotNull(aw.getMsWines());
		assertEquals(YearMonth.parse("2015-11"), aw.getYearmonth());
		Wine wine4 = new Wine();
		wine4.setWineVariety(WineVariety.WHITE);
		aw.addWine(wine4);
	}

	@Test
	public void test_monthlyselection_throughYearMonth(){
		AR ms = new AR("2015-11");
		Wine wine4 = new Wine();
		
		ms.addWine(wine4);
		assertNotNull(ms.getMsWines());
		assertNotNull(ms.getSelectionID());
		assertEquals(YearMonth.parse("2015-11"), ms.getYearmonth());
		
		List<Wine> emptyWines = new ArrayList<Wine>();
		emptyWines.clear();
		ms.setMsWines(emptyWines);
		assertNotNull(ms.getMsWines());
		ms.setYearmonth(YearMonth.parse("2014-10"));
		assertEquals(YearMonth.parse("2014-10"), ms.getYearmonth());
		assertEquals("All reds", MonthlySelectionType.AR.getDescription());
		MonthlySelectionType.AR.setDescription("hella good");
		assertEquals("hella good", MonthlySelectionType.AR.getDescription());
	}
	
	@Test
	public void test_RW(){
		RW newRW = new RW("2015-12");
		Wine wine = new Wine();
		wine.setWineVariety(WineVariety.WHITE);
		newRW.addWine(wine);
	}
	
	@Test
	public void test_AW(){
		AW newAW = new AW("2015-12");
		Wine wine = new Wine();
		newAW.addWine(wine);
	}
}
