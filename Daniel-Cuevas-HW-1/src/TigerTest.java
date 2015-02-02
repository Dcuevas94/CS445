import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class TigerTest {
	Tiger tigg1 = new Tiger("Tigg1");
	Tiger tigg2 = new Tiger();
	Tiger testtiger = new Tiger();
	Thing thing1 = new Thing("food");
	Thing thing2 = new Thing();
	String lineseperator = System.getProperty("line.separator");
	
	@Test
	public void testMove() {
		String expected = "Tigg1 Tiger has just pounced";
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		tigg1.move();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testTigerString() {
		tigg1.getName();
		String expected = "Tigg1";
		assertEquals(expected, tigg1.getName());
		
	}

	@Test
	public void testTiger() {
		String expected = "Creature";
		assertEquals(expected, tigg2.getName());
	}

	@Test
	public void testEat() {
		String expected = "Tigg1 has just eaten a food";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		tigg1.eat(thing1);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testEatThing() {
		String expected = "Tigg1 has just eaten a Thing";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		tigg1.eat(thing2);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testWhatDidYouEat() {
		String expected = "Tigg1 Tiger has eaten a food!";
		tigg1.eat(thing1);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		tigg1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testToString() {
		String expected = "Tigg1 Tiger";
		assertEquals(expected, tigg1.toString());
	}

}
