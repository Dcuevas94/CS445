import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class FlyTest {
	Fly fly1 = new Fly("fly1");
	Fly fly2 = new Fly();
	Tiger tiger1 = new Tiger("tiger1");
	Thing thing1 = new Thing("food");
	Thing thing2 = new Thing();
	String lineseperator = System.getProperty("line.separator");

	@Test
	public void testEat() {
		String expected = "fly1 has just eaten a Thing";
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.eat(thing1);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testEatCreature() {
		//			System.out.println(name + " " + superClassName + " won't eat a " + ate);
		String expected = "fly1 Creature won't eat a tiger1";
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.eat(tiger1);
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testMove() {
		//System.out.println(name + " " + className + " is buzzing around in flight");
		String expected = "fly1 Fly is buzzing around in flight";
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.move();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	
	@Test
	public void testFlyMove() {
		//System.out.println(name + " " + className + " is buzzing around in flight");
		String expected = "fly1 Fly is buzzing around in flight";
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.fly();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testFlyString() {
		Fly fly3 = new Fly("Fly3");
		String expected = "Fly3";
		assertEquals(expected, fly3.getName());
	}

	@Test
	public void testFly() {
		Fly fly4 = new Fly();
		String expected = "Creature";
		assertEquals(expected, fly4.getName());
	}
	@Test
	public void testWhatDidYouEatThing() {
		String expected = "fly1 Fly has eaten a Thing!";
		fly1.eat(thing1);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testWhatDidYouEatTiger() {
		String expected = "fly1 Fly has had nothing to eat!";
		Tiger tig2 = new Tiger();
		fly1.eat(tig2);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}
	@Test
	public void testWhatDidYouEatCreature() {
		String expected = "fly1 Fly has had nothing to eat!";
		fly1.eat(tiger1);
		
		PrintStream originalOut = System.out;
		OutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		System.setOut(printStream);
		
		fly1.whatDidYouEat();
		
		assertEquals(expected+lineseperator,outStream.toString());	
		System.setOut(originalOut);
	}

	@Test
	public void testToString() {
		String expected = "fly1 Fly";
		assertEquals(expected, fly1.toString());
	}

}
