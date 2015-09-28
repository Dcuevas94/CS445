package edu.iit.cs445.VIN_Cuevas;

import static org.junit.Assert.*;

import org.junit.Test;


public class ShipmentsTest {
	
	Shipments ship = new Shipments();
	
	@Test
	public void testShipments() {
		assertEquals("Delivered",ship.getStatus());
		assertEquals(0, ship.getShipmentIDs());
	}
	
	@Test
	public void test_setDesc(){
		ship.setStatus("Failed");
		assertEquals("Failed", ship.getStatus());
	}
	
	@Test
	public void test_nonDefailt_Shipment(){
		Shipments ship2 = new Shipments(new AR(), "Delivered", 9);
		assertEquals("Delivered", ship2.getStatus());
		assertEquals(9, ship2.getShipmentIDs());
	}

}
