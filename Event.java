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
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Event represents events to be held in .
 */
public class Event implements Interval{
	//TODO add private data members
	private long start; 
	private long end;
	private String name;
	private String resource;
	private String organization;
	private String description;
	Event(long start, long end, String name, String resource, String organization, String description){
		//TODO Remove this exception and implement the method
		this.start = start;
		this.end = end;
		this.name = name;
		this.resource = resource;
		this.organization = organization;
		this.description = description;
	}

	@Override
	public long getStart(){
		//TODO Remove this exception and implement the method
		return start;
	}

	@Override
	public long getEnd(){
		//TODO Remove this exception and implement the method
		return end;
	}

	public String getName() {
		//TODO Remove this exception and implement the method
		return name;
	}

	public String getResource() {
		//TODO Remove this exception and implement the method
		return resource;
	}
	
	public String getOrganization(){
		//TODO Remove this exception and implement the method
		return organization;
	}

	public String getDescription() {
		//TODO Remove this exception and implement the method
		return description;
	}

	@Override
	public int compareTo(Interval i) {
		//TODO Remove this exception and implement the method
		return this.start < i.getStart() ? -1 : 1;
	}
	
	
	public boolean equals(Event e) {
		
		return this.start == e.getStart();
	}

	@Override
	public boolean overlap(Interval i) {
		//TODO Remove this exception and implement the method
		return (this.start > i.getStart() && this.start < i.getEnd()) || 
		(i.getStart() > this.start && i.getStart() < this.end);
	}
	
	@Override
	public String toString(){
		//TODO Remove this exception and implement the method
		String formattedStart = null;
		String formattedEnd = null;
		try{
			Date dateStart = new Date(start*1000);
			formattedStart = new SimpleDateFormat("MM/dd/yyyy,HH:mm").format(dateStart);
			Date dateEnd = new Date(end*1000);
			formattedEnd = new SimpleDateFormat("MM/dd/yyyy,HH:mm").format(dateEnd);
		}catch(Exception e){
			System.out.println("Dates are not formatted correctly.  Must be \"MM/dd/yyyy,HH:mm\"");
		}
	
		StringBuilder result = new StringBuilder();
		String nextLine = "\n";
		result.append(this.name);
		result.append(nextLine);
		result.append("By: ");
		result.append(this.organization);
		result.append(nextLine);
		result.append("In: ");
		result.append(this.resource);
		result.append(nextLine);
		result.append("Start: ");
		result.append(formattedStart);
		result.append(nextLine);
		result.append("End: ");
		result.append(formattedEnd);
		result.append(nextLine);
		result.append("Description: ");
		result.append(this.description);
		return result.toString();
	}
}