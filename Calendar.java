package pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.io.*; 
import java.util.Scanner;


public class Calendar {

	ArrayList<Event> events;
	
	public Calendar() {
	 events = new ArrayList<Event>(); // Create an ArrayList of Event
	}
	
	void addEvent(Event event , PhoneBook book)
	{
		if( event instanceof EventWithMeeting) {   //meeting with contacts of PhoneBook
			if(book.contains(((EventWithMeeting) event).contact)) {   //use the functions of ArrayList
				events.add(event);}}
		if( event instanceof EventWithoutMeeting) {
			events.add(event);
		}
	}

	void deleteEvent(Event event) {
		events.remove(event);
	}
	
	void printAccordingToADate(Date date) {
		
		ArrayList<Event> events_2 = new ArrayList<Event>(); // Create an ArrayList of Event
		
		for (int counter = 0; counter < events.size(); counter++) { 		      
	          if (date==events.get(counter).date) {   
	        	 events_2.add(events.get(counter));
	          }
	      }
		Collections.sort(events_2);   // call the function Comparableto
		for (int counter = 0; counter < events_2.size(); counter++) {
			events.get(counter).print();   //use print of event
		}
	}
	
	
	void printAccordingToAContact( Contact contacte) {
		
		ArrayList<Event> events_3 = new ArrayList<Event>(); // Create an ArrayList of Event
		for (int counter = 0; counter < events.size(); counter++) { 	
			if(events.get(counter) instanceof EventWithMeeting )
			{
				if(events.get(counter).getContact()==contacte) {
					events_3.add(events.get(counter));
				}
			}
		}
		Collections.sort(events_3);   // call the function Comparableto
		for (int counter = 0; counter < events_3.size(); counter++) {
			events.get(counter).print();   //use print of event
		}
	}
	
	void printAllEvents() {
		for (int counter = 0; counter < events.size(); counter++) {
			events.get(counter).print(); 
		}
	}
	
	
	
	
	
	
}
