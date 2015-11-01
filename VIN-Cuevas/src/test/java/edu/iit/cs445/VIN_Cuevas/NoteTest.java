package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class NoteTest {

	@Test
	public void test_note(){
		Note note = new Note();
		int id = note.getID();
		assertEquals("", note.getContent());
		assertEquals(id, note.getID());
		assertNotNull(note.getDate());
		note.setContent("Hello!");
		assertEquals("Hello!", note.getContent());
		note.setCurrentDate();
		assertNotNull(note.getDate());
		note.modifyContent("This is it!");
		assertEquals("This is it!", note.getContent());
	}
	
	@Test
	public void test_nonDefault_note(){
		Note note = new Note("THIS IS A NEW NOTE!");
		assertEquals("THIS IS A NEW NOTE!", note.getContent());
	}
}
