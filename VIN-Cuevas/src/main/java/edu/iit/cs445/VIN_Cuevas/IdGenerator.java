package edu.iit.cs445.VIN_Cuevas;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

	private static AtomicInteger nextID = new AtomicInteger();
	private static AtomicInteger adminID = new AtomicInteger();
	private static AtomicInteger wineID = new AtomicInteger();
	private static AtomicInteger monthlyID = new AtomicInteger();
	private static AtomicInteger shipID = new AtomicInteger();
	//private static AtomicInteger onlyWineID = new AtomicInteger();
	private static AtomicInteger noteID = new AtomicInteger();
	
	public static int newID(){
		return nextID.getAndIncrement();
	}
	
	public static int newIDadmin(){
		return adminID.getAndIncrement();
	}

	public static int newIDwine(){
		return wineID.getAndIncrement();
	}
	
	public static int newIDms(){
		return monthlyID.getAndIncrement();
	}

	public static int newIDship() {
		return shipID.getAndIncrement();
	}
//	public static int newIDwineOnly(){
//		return onlyWineID.getAndIncrement();
//	}
	
	public static int newIDnote(){
		return noteID.getAndIncrement();
	}
}
