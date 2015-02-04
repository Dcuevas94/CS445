import static org.junit.Assert.*;

import org.junit.Test;

public class ThingTest {
	Thing thing1 = new Thing();
	Thing thing2 = new Thing("JustaThing");
	String lineseperator = System.getProperty("line.separator");
	
	@Test
	public void testThingString() {
		Thing thing3 = new Thing("Laptop");
		String expected = "Laptop";
		assertEquals(expected, thing3.getName());
	}

	@Test
	public void testThing() {
		Thing thing4 = new Thing();
		String expected = "Thing";
		assertEquals(expected, thing4.getName());
	}

	@Test
	public void testSetName() {
		thing2.setName("AnewThing");
		String expected = "AnewThing";
		assertEquals(expected, thing2.getName());
	}

	@Test
	public void testGetName() {
		String expected = "JustaThing";
		assertEquals(expected, thing2.getName());
	}

	@Test
	public void testToString() {
		String expected = "JustaThing";
		assertEquals(expected, thing2.toString());
	}

}
