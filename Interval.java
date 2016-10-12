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
public interface Interval extends Comparable<Interval>{
	/**
     * Returns the start of the interval.
     * @return the start
     */
	long getStart();
	
	/**
     * Returns the end of the interval.
     * @return the end
     */
	long getEnd();
	
	/**
     * Returns whether there is an overlap between the two intervals.
     * @return if there is an overlap between the intervals.
     */
	boolean overlap(Interval otherInterval);
}