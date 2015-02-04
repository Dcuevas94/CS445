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
	public void testEatAnt() {
		String expected = "Antty has just eaten a Ant";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.eat(ant2);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testEatTiger() {
		Tiger tig3 = new Tiger();
		String expected = "Antty has just eaten a Tiger";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.eat(tig3);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testEatFly() {
		Fly fly2 = new Fly();
		String expected = "Antty has just eaten a Fly";

		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.eat(fly2);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testEatBat() {
		String expected = "Antty has just eaten a Bat";
		Bat bat3 = new Bat();
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.eat(bat3);
		
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
	public void testWhatDidYouEatThing() {
		String expected = "Antty Ant has eaten a Thing!";
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
	public void testWhatDidYouEatTiger() {
		String expected = "Antty Ant has eaten a Tiger!";
		Tiger tig4 = new Tiger();
		ant1.eat(tig4);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testWhatDidYouEatAnt() {
		String expected = "Antty Ant has eaten a Ant!";
		Ant ant4 = new Ant();
		ant1.eat(ant4);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testWhatDidYouEatFly() {
		String expected = "Antty Ant has eaten a Fly!";
		Fly fly4 = new Fly();
		ant1.eat(fly4);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		ant1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testWhatDidYouEatBat() {
		String expected = "Antty Ant has eaten a Bat!";
		Bat bat4 = new Bat();
		ant1.eat(bat4);
		
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
