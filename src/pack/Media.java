package pack;

import java.util.*;

// this class is a father class for all types of media (music and videos)
public abstract class Media {
	String name;
	double length;
	
	
	public Media(String name, double length) {
		this.name = name;
		this.length = length;

	}
	
	
	 public String toString() {
		String s = String.valueOf(length);// convert double to string
		String str = "";
		str += name +" is now playing for " + s + " minutes";
		return str;
	}

	
	
}
