import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class BatTest {
	Bat bat1 = new Bat("Batty");
	Bat bat2 = new Bat();
	Bat bat3 = new Bat("Batman");
	Tiger tig1 = new Tiger("tig1");
	Ant ant1 = new Ant("Antty");
	Fly fly1 = new Fly("Flyz");
	Thing thing1 = new Thing("garbageThing");
	Thing thing2 = new Thing();
	String lineseperator = System.getProperty("line.separator");
	
	@Test
	public void testEat() {
		String expected = "Batty has just eaten a Antty";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		bat1.eat(ant1);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testEatThing() {
		String expected = "Batty Bat won't eat a garbageThing";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		bat1.eat(thing1);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testMove() {
		String expected = "Batty Bat is swooping through the dark";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		bat1.move();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testBatString() {
		String expected = "Creature";
		assertEquals(expected, bat2.getName());
	}

	@Test
	public void testBat() {
		String expected = "Batty";
		assertEquals(expected, bat1.getName());
	}
	
	@Test
	public void testFly() {
		String expected = "Batty Bat is swooping through the dark";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		bat1.fly();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testWhatDidYouEat() {
		String expected = "Batty Bat has eaten a tig1!";
		bat1.eat(tig1);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		bat1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testWhatDidYouEatThing() {
		String expected = "Batman Bat has had nothing to eat!";
		bat3.eat(thing1);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		bat3.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testToString() {
		String expected = "Batty Bat";
		assertEquals(expected, bat1.toString());
	}

}
