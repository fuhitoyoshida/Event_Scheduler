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
import java.util.Iterator;


public class Resource {
	private String name;
	private SortedListADT<Event> events;
	
	Resource(String name){
		this.name = name;
		events = new IntervalBST<Event>();
	}
	
	public String getName(){
		return name;
	}
	
	public boolean addEvent(Event e){
		if(e == null) return false;
		events.insert(e);
		return true;
	}
	
	public boolean deleteEvent(long start){
		return events.delete(new Event(start, start, "", "", "", ""));
	}
	
	public Iterator<Event> iterator(){
		return events.iterator();
	}
	
}