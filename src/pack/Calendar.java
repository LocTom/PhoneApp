package pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Calendar {

	static ArrayList<Event> events;
	PhoneBook book;
	/*
	static void eraseContactEvent(Contact cont)
	{
		
		for (Event e:events) {
			
		}
	}
	*/
	public void run() {       
		
		events = new ArrayList<Event>();
		int a;
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			try {
				System.out.println("what you you like to do?\r\n"
						+"(1) Add an Event \r\n"
						+"(2) Delete an Event\r\n"
						+"(3) Show all the events according to a date\r\n"
						+"(4) Show all the events according to a contact\n"
						+"(5) Show Events collision \n"
						+"(6) Show all events\n"
						+"(7) Exit");
				a = scan.nextInt();// get users choice and call function accordingly 
				scan.nextLine();// get rid of EOL symbol
				
				switch (a) {
				
				case 1 :// add an event
					Event event = ScanEvent(book);
					addEvent(event,book);
					break;
					
				case 2 :
					printAllEvents();
					System.out.println("enter the number of the event you want to delete\n");
					int index = scan.nextInt();
					deleteEvent(events.get(index));
					break;
				case 3 :
					Date date = scanDate();
					printAccordingToADate(date);
					break;
				case 4 :
					Contact contact = scanExistingContact(book);
					printAccordingToAContact(contact);
					break;
				case 5 :
					EventsCollision();
					break;
				case 6 :
					System.out.println("case6");
					printAllEvents();
					break;
				case 7: 
					scan.close();
					return;
					
				default:
					System.out.println("choose an option between 1-7\n");
				}//try
				
				}// switch case
				catch (Exception e)
				{
					System.out.println( e.getMessage());
				}
				
				}
			}
			
		

	
	public Calendar(PhoneBook a) {
		events = new ArrayList<Event>(); // Create an ArrayList of Event
		book = a;
	}
	
	public Date scanDate() {
		int day,month,year;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter a day\n");
		day = scan.nextInt();
		while(day < 1 || day > 31) {
			System.out.println("Day must be between 1 and 31. Please enter a day again\n");
			day = scan.nextInt();
		}
		System.out.println("enter a month\n");
		month = scan.nextInt();
		while(month < 1 || month > 12) {
			System.out.println("Month must be between 1 and 12. Please enter a month again\n");
			month = scan.nextInt();
		}
		System.out.println("enter a year\n");
		year = scan.nextInt();
		while(year < 2021) {
			System.out.println("Year must be in 2021 or after. Please enter a year again\n");
			year = scan.nextInt();
		}
		Date date = new Date(month,day,year);
		return date;
	}
	
	public DateTime scanDateTime() {
		Date date = scanDate();
		int hour,min,sec;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter a hour\n");
		hour = scan.nextInt();
		while(hour < 0 || hour >= 24) {
			System.out.println("Hour must be between 0 and 24. Please enter an hour again\n");
			hour = scan.nextInt();
		}
		System.out.println("enter a minute\n");
		min = scan.nextInt();
		while(min < 0 || min >= 60) {
			System.out.println("Minute must be between 0 and 60. Please enter a minute again\n");
			min = scan.nextInt();
		}
		System.out.println("enter a seconde\n");
		sec = scan.nextInt();
		while(sec < 0 || sec >= 60) {
			System.out.println("Seconde must be between 0 and 60. Please enter a second again\n");
			sec = scan.nextInt();
		}
		DateTime dateTime = new DateTime(date.month,date.day,date.year,hour,min,sec);
		return dateTime;
	}
	
	public Contact scanExistingContact(PhoneBook book) {
		String name;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter a name\n");
		
		name= scan.nextLine();
		System.out.println(name);
		Contact contact = book.findContact(name);
		return contact;
	}
	
	public Event ScanEvent(PhoneBook book) {
		int time,res;
		String description;
		Scanner scan = new Scanner(System.in);
		System.out.println("1 for Event With Meeting and 2 for Event Without meeting \n");
		res= scan.nextInt();
		scan.nextLine();
		if (res == 1 && book.isEmpty())
		{
			System.out.println("first add contact");
			return null;
		}
		
		DateTime dateTime = scanDateTime();
		System.out.println("enter a duration\n");
		time= scan.nextInt();
		scan.nextLine();
		if (res == 1) {		
			book.printBook();
			Contact contact = scanExistingContact(book);
			EventWithMeeting eventmeeting = new EventWithMeeting(contact, time , dateTime); 
			return eventmeeting;
		}
		if (res ==2 ) {
			System.out.println("enter a description");
			description= scan.nextLine();
			EventWithoutMeeting eventnomeeting = new EventWithoutMeeting(description,time,dateTime);
			return eventnomeeting;
		}
		return null;
		
	}
	
	void addEvent(Event event, PhoneBook book)
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
	          if (date.equals(events.get(counter).dateTime.date)) {   
	        	 events_2.add(events.get(counter));
	          }
	      }

		Collections.sort(events_2);   // call the function Comparableto

		for (int counter = 0; counter < events_2.size(); counter++) {
			events.get(counter).print();   //use print of event
		}
		
		if (events_2.size() == 0) {
			System.out.println("There is no events for this date");
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
		
		if (events_3.size() == 0) {
			System.out.println("There is no events for this contact");
		}
	}
	
	void printAllEvents() {
		for (int counter = 0; counter < events.size(); counter++) {
			System.out.println(counter + " " + events.get(counter).toString());
		}
	}
	
	void EventsCollision() {
		class EventWithJavaDate implements Comparable<EventWithJavaDate> {
			Event event;
			LocalDateTime javaStartDate;
			LocalDateTime javaEndDate;
			
			public EventWithJavaDate(Event event2, LocalDateTime startDateTime, LocalDateTime endDateTime) {
				event = event2;
				javaStartDate = startDateTime;
				javaEndDate = endDateTime;
			}
			
			 public int compareTo(EventWithJavaDate eventWithJavaDate) {
				 return this.javaStartDate.compareTo(eventWithJavaDate.javaStartDate);
			 }
			 
			
		}
		
		ArrayList<EventWithJavaDate> eventWithJavaDates = new ArrayList<EventWithJavaDate>();
		for (int i = 0; i < events.size(); i++) {
			DateTime dateTime = events.get(i).dateTime;
			LocalDateTime startDateTime = LocalDateTime.of(dateTime.date.year, dateTime.date.month, dateTime.date.day, dateTime.hour, dateTime.min, dateTime.sec);
			LocalDateTime endDateTime = startDateTime.plusMinutes(events.get(i).time);
			EventWithJavaDate eventWithJavaDate = new EventWithJavaDate(events.get(i), startDateTime, endDateTime);
			eventWithJavaDates.add(eventWithJavaDate);
		}
		Collections.sort(eventWithJavaDates);
		
		for (int i = 0; i < eventWithJavaDates.size() - 1; i++) {
			if(!(eventWithJavaDates.get(i).javaEndDate.isBefore(eventWithJavaDates.get(i+1).javaStartDate))) {
				System.out.println("There is a collision. We delete the event " + eventWithJavaDates.get(i+1).event.toString());
				this.deleteEvent(eventWithJavaDates.get(i+1).event);
			}
		}
	}
	
	
	
	
	
}
