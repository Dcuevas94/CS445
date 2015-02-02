import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class AntTest {
	Ant ant1 = new Ant("Antty");
	Ant ant2 = new Ant();
	Thing thing1 = new Thing("food");
	Thing thing2 = new Thing();
	String lineseperator = System.getProperty("line.separator");
	
	@Test
	public void testMove() {
		String expected = "Antty Ant, is crawling around";
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.move();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testAntString() {
		String expected = "Antty";
		assertEquals(expected, ant1.getName());
	}

	@Test
	public void testAnt() {
		String expected = "Creature";
		assertEquals(expected, ant2.getName());
	}

	@Test
	public void testEat() {
		String expected = "Antty has just eaten a Creature";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.eat(ant2);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testEatThing() {
		String expected = "Antty has just eaten a Thing";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.eat(thing2);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	

	@Test
	public void testWhatDidYouEat() {
		String expected = "Antty Ant has eaten a food!";
		ant1.eat(thing1);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testToString() {
		String expected = "Antty Ant";
		assertEquals(expected, ant1.toString());
	}

}
