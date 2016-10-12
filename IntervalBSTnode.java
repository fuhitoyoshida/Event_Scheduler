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
class IntervalBSTnode<K extends Interval> {
 	private K keyValue;
 	private IntervalBSTnode<K> leftChild;
 	private IntervalBSTnode<K> rightChild;
 	private long maxEnd;
    public IntervalBSTnode(K keyValue) {
		//TODO Remove this exception and implement the method
		this.keyValue = keyValue;
		this.leftChild = null;
		this.rightChild = null;
		this.maxEnd = keyValue.getEnd(); //single node maxEnd is the interval's end
    }
    
    public IntervalBSTnode(K keyValue, IntervalBSTnode<K> leftChild, IntervalBSTnode<K> rightChild, long maxEnd) {
		//TODO Remove this exception and implement the method
    	this.keyValue = keyValue;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.maxEnd = maxEnd;
    }

    public K getKey() { 
		//TODO Remove this exception and implement the method
		return this.keyValue;
    }
    
    public IntervalBSTnode<K> getLeft() { 
		//TODO Remove this exception and implement the method
		return this.leftChild;
    }
  
    public IntervalBSTnode<K> getRight() { 
		//TODO Remove this exception and implement the method
		return this.rightChild;
    }
 
    public long getMaxEnd(){
		//TODO Remove this exception and implement the method
		return maxEnd;
    }
 
    public void setKey(K newK) { 
		//TODO Remove this exception and implement the method
		this.keyValue = newK;
    }
    
    
    public void setLeft(IntervalBSTnode<K> newL) { 
		//TODO Remove this exception and implement the method
		this.leftChild = newL;
    }
    
    public void setRight(IntervalBSTnode<K> newR) { 
		//TODO Remove this exception and implement the method
		this.rightChild = newR;
    }
    
    public void setMaxEnd(long newEnd) { 
    	this.maxEnd = newEnd;
    }
    
    public long getStart(){ 
		//TODO Remove this exception and implement the method
		return keyValue.getStart();
	}

    public long getEnd(){
		//TODO Remove this exception and implement the method
		return keyValue.getEnd();
	}

    public K getData(){
		//TODO Remove this exception and implement the method
		return keyValue;
	}
    
}

