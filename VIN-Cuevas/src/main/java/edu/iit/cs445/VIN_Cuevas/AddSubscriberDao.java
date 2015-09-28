package edu.iit.cs445.VIN_Cuevas;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class AddSubscriberDao {
	
private Map<String, Subscriber> subscribers;
	
	public AddSubscriberDao() {
		subscribers = new ConcurrentHashMap<String, Subscriber>();
		//Extra stuff for testing
		//Subscriber sub1 = new Subscriber("Dan", "dcuevas@hawk.iit.edu", "23456789", new Address("State", "Chicago", "IL", "3456" ));
		//addSubscriber(sub1);
	}
	
	public Collection<Subscriber> getSubsciber(){
		return(subscribers.values());
	}
	
	public Subscriber getSubsciber(String id){
		return(subscribers.get(id));
	}
	
	public Subscriber addSubscriber(Subscriber subscriber){
		String subID = Integer.toString(subscriber.getID());
			subscribers.put(subID, subscriber);
			return(subscriber);
	}
	
	//PUT using id
	//PUT was removed from the requirments
//	public Subscriber updateSubscriber(String id){
//		Iterator<Entry<String, Subscriber>> eachSubscriber = subscribers.entrySet().iterator();
//		Subscriber tempSubscriber;
//		while (eachSubscriber.hasNext()){
//			System.out.println("iterate");
//			tempSubscriber = (Subscriber) eachSubscriber.next();
//			if(Integer.toString(tempSubscriber.getID())==id){
//				System.out.println("update with id");
//				tempSubscriber.setName(tempSubscriber.getName());
//				tempSubscriber.setEmail(tempSubscriber.getEmail());
//				tempSubscriber.setPhone(tempSubscriber.getPhone());
//				tempSubscriber.setAddress(tempSubscriber.getAddress());
//				tempSubscriber.setFacebook(tempSubscriber.getFacebook());
//				tempSubscriber.setTwitter(tempSubscriber.getTwitter());
//				subscribers.put(id, tempSubscriber);
//				//return(subscribers.get(id));
//			} else {
//				addSubscriber(tempSubscriber);
//			}
//		}
//		return(subscribers.get(id));
//	}
	
	//PUT using subscriber
	//PUT was removed from the requirments
//	public Subscriber updateSubscriber(Subscriber subscriber){
//		Iterator<Entry<String, Subscriber>> eachSubscriber = subscribers.entrySet().iterator();
//		Subscriber tempSubscriber;
//		while (eachSubscriber.hasNext()){
//			tempSubscriber = (Subscriber) eachSubscriber.next();
//			if(tempSubscriber.getID()==subscriber.getID()){
//				System.out.println("inside iteration");
//				tempSubscriber.setName(subscriber.getName());
//				tempSubscriber.setEmail(subscriber.getEmail());
//				tempSubscriber.setPhone(subscriber.getPhone());
//				tempSubscriber.setAddress(subscriber.getAddress());
//				tempSubscriber.setFacebook(subscriber.getFacebook());
//				tempSubscriber.setTwitter(subscriber.getTwitter());
//				subscribers.put(Integer.toString(tempSubscriber.getID()), tempSubscriber);
//				return(subscriber);
//			} else {
//				subscribers.put(Integer.toString(subscriber.getID()), subscriber);
//				System.out.println("created new subscriber");
//			}
//		}
//		return subscriber;
//	}
	
	@SuppressWarnings("unused")
	private boolean userHasAccount(Subscriber sub){
		//Iterator<Subscriber> eachSubscriber = subscribers.
		Iterator<Entry<String, Subscriber>> entries = subscribers.entrySet().iterator();
		Subscriber tempSubscriber;
		while (entries.hasNext()){
			tempSubscriber = (Subscriber) entries.next();
			if((sub.getEmail()).equals(tempSubscriber.getEmail())){
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean addressInBannedState(Address a) {
		if (a.getState().equals("AR")|| (a.getState().equals("AL"))
				|| (a.getState().equals("DE"))|| (a.getState().equals("KY"))
				|| (a.getState().equals("MA"))|| (a.getState().equals("MS"))
				|| (a.getState().equals("SD"))|| (a.getState().equals("UT"))){
			return true;
		}
		return false;
	}
	
}
