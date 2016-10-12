///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (name of main application class)
// File:             (name of this class's file)
// Semester:         (course) Fall 2015
//
// Author:           (your name and email address)
// CS Login:         (your login name)
// Lecturer's Name:  (name of your lecturer)
// Lab Section:      (your lab section number)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;



public class SchedulerDB {
	//TODO add private data members
	 private List<Resource> resourceList;
	 private int numItems;
	 
	SchedulerDB(){
		//TODO Remove this exception and implement the method
		resourceList = new ArrayList<Resource>();
		numItems = 0;
	}
	
	public boolean addResource(String resource){
		//TODO Remove this exception and implement the method
		if(resource == null) throw new IllegalArgumentException();
		//If resource name is empty
		if(resource.length() == 0) return false;
		
		//Look for duplicates of resource in the list
		Iterator<Resource> itr = resourceList.iterator();
		while(itr.hasNext()){
			Resource addR = itr.next();
			if(addR.getName().equals(resource)){
				return false;
			}
		}
		//Successful adding
		Resource newR = new Resource(resource);
		resourceList.add(newR);
		numItems++;
		return true;
	}
	
	public boolean removeResource(String r){
		//TODO Remove this exception and implement the method
		if(numItems == 0) return false;
		
		Iterator<Resource> itr = resourceList.iterator();
		while(itr.hasNext()){
			Resource deleteR = itr.next();
			if(deleteR.getName().equals(r)){
				resourceList.remove(deleteR);
				numItems--;
				return true;
			}
		}
		return false;
	}
	
	public boolean addEvent(String resource, long start, long end, String name, 
			String organization, String description){
		//TODO Remove this exception and implement the method
		if(resource == null || name == null || organization == null || description == null) throw new IllegalArgumentException();
		if(resource.length() == 0) return false;
		
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Resource findR = itrR.next();
			if(findR.getName().equals(resource)){
				Iterator<Event> itrE = findR.iterator();
				while(itrE.hasNext()){
					//duplicates of Event
					if(itrE.next().getName().equals(name)){
						return false;
					}
				}
				findR.addEvent(new Event(start, end, name, resource, organization, description));
				return true;
			}
		}
		return false;
		
	}
	public boolean deleteEvent(long start, String resource){
		//TODO Remove this exception and implement the method
		if(resource == null) throw new IllegalArgumentException();
		
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Resource findR = itrR.next();
			if(findR.getName().equals(resource)){
				findR.deleteEvent(start);
				return true;
			}
		}
		return false;
	}
	
	public Resource findResource(String r){
		//TODO Remove this exception and implement the method
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Resource findR = itrR.next();
			if(findR.getName().equals(r)) return findR;
		}
		return null; 
	}
	
	public List<Resource> getResources(){
		//TODO Remove this exception and implement the method
		return resourceList;
	}
	
	public List<Event> getEventsInResource(String resource){
		//TODO Remove this exception and implement the method
		if(resource == null) throw new IllegalArgumentException();
		List<Event> eventList = new ArrayList<Event>();
		
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Resource findR = itrR.next();
			if(findR.getName().equals(resource)){
				Iterator<Event> itrE = findR.iterator();
				while(itrE.hasNext()){
					eventList.add(itrE.next());
				}
			}
		}
		return eventList;
	}
	
	public List<Event> getEventsInRange(long start, long end){
		//TODO Remove this exception and implement the method
		List<Event> eventList = new ArrayList<Event>();
		Interval i = new Event(start, end,"dummy","dummy","dummy","dummy");
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Iterator<Event> itrE = itrR.next().iterator();
			while(itrE.hasNext()){
				Event event = itrE.next();
				if(event.overlap(i)){
					eventList.add(event);
				}
			}
		}
		return eventList;
		
	}	
	
	public List<Event> getEventsInRangeInResource(long start, long end, String resource){
		//TODO Remove this exception and implement the method
		List<Event> eventList = new ArrayList<Event>();
		Interval i = new Event(start, end, "dummy", "dummy", "dummy", "dummy");
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Resource findR = itrR.next();
			if(findR.getName().equals(resource)){
				Iterator<Event> itrE = findR.iterator();
				while(itrE.hasNext()){
					Event event = itrE.next();
					if(event.overlap(i)){
						eventList.add(event);
					}
				}
			}
		}
		return eventList;
	}
	
	public List<Event> getAllEvents(){
		//TODO Remove this exception and implement the method
		List<Event> eventList = new ArrayList<Event>();
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Iterator<Event> itrE = itrR.next().iterator();
			while(itrE.hasNext()){
				eventList.add(itrE.next());
			}
		}
		return eventList;
	}
	
	public List<Event> getEventsForOrg(String org){
		//TODO Remove this exception and implement the method
		List<Event> eventList = new ArrayList<Event>();
		Iterator<Resource> itrR = resourceList.iterator();
		while(itrR.hasNext()){
			Resource findR = itrR.next();
			Iterator<Event> itrE = findR.iterator();
			while(itrE.hasNext()){
				Event event = itrE.next();
				if(event.getOrganization().equals(org)){
					eventList.add(event);
				}
			}
		}
		 return eventList;		
	}
}