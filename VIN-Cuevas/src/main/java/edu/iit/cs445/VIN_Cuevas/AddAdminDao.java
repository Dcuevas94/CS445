package edu.iit.cs445.VIN_Cuevas;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AddAdminDao {
	private Map<String, Admin> admins;
	
	public AddAdminDao() {
		admins = new ConcurrentHashMap<String, Admin>(); //make dummy admins here
	}
	
	public Collection<Admin> getAdmin(){
		return(admins.values());
	}
	
	public Admin getAdmin(String id){
		return(admins.get(id));
	}
	
	public Admin addAdmin(Admin admin){
		String adminID = Integer.toString(admin.getID());
		admins.put(adminID, admin);
		return(admin);
	}
}
