package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.YearMonth;

import org.junit.Test;


public class ShipmentsTest {
	
	Shipments ship = new Shipments();
	
	@Test
	public void testShipments() {
		assertEquals(ShipmentStatus.PENDING,ship.getStatus());
		assertNotNull(ship.getShipmentIDs());
	}
	
	@Test
	public void test_setDesc(){
		ship.setStatus(ShipmentStatus.CANCELLED);
		assertEquals(ShipmentStatus.CANCELLED, ship.getStatus());
	}
	
	@Test
	public void test_nonDefailt_Shipment(){
		Shipments ship2 = new Shipments(new AR(), "10-2012") ;
		ship2.setStatus(ShipmentStatus.DELIVERED);
		assertEquals(ShipmentStatus.DELIVERED, ship2.getStatus());
		assertNotNull(ship2.getShipmentIDs());
	}

	@Test
	public void test_year_month(){
		Shipments ship3 = new Shipments();
		System.out.println(ship3.getYearMonth());
		assertEquals(ship3.getYearMonth(), YearMonth.parse("2015-11"));
		ship3.setYearMonth(YearMonth.parse("2015-11"));
		System.out.println(ship3.getYearMonth());
		assertEquals(YearMonth.parse("2015-11"), ship3.getYearMonth());
	}
	
	@Test
	public void test_date(){
		Shipments ship4 = new Shipments();
		System.out.println(ship4.getDate());
	}
	
	@Test
	public void test_getters_and_setters(){
		Shipments ship1 = new Shipments();
		assertNotNull(ship1.getMonthlySelection());
		assertEquals(1, ship1.getQuantity());
		assertEquals(25.99, ship1.getPrice(), 0);
		assertEquals(3.99, ship1.getDeliveryFee(), 0);
		assertNotNull(ship1.getNotes());
		ship1.setMonthlySelection(new AW());
		assertNotNull(ship1.getMonthlySelection());
		ship1.setQuantity(3);
		assertEquals(3, ship1.getQuantity());
		ship1.setPrice(34.99);
		assertEquals(34.99, ship1.getPrice(), 0);
		ship1.setDeliveryFee(4.99);
		assertEquals(4.99, ship1.getDeliveryFee(), 0);
		ship1.setCurrentDate();
		ship1.addNote(new Note("This is a new note"));
		assertEquals(0, ship1.getNotes().size());
		ship1.addNote(new Note("This is a new note and it will be a lot longer so it can work"));
		assertEquals(1, ship1.getNotes().size());
		ship1.addNote(new Note("This is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can workThis is a new note and it will be a lot longer so it can work"));
		assertEquals(1, ship1.getNotes().size());
		Note note = new Note("This is a new note and it will be a lot longer so it can work");
		ship1.addNote(note);
		assertEquals(2, ship1.getNotes().size());
		ship1.deleteNote(note);
		
	}
}
