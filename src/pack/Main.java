package pack;


public class Main {

	public static void main(String[] args) { 
	PhoneBook book = new PhoneBook(); // use the constructor of ArrayList<contact>
	Contact contact = new Contact(852,"Sarah");
	book.add(contact);
	Calendar calendar= new Calendar();
	
	Date date= new Date(2,14,2021);
	EventWithMeeting eventmeeting  = new EventWithMeeting(contact,54,date);
	calendar.addEvent(eventmeeting,book);
	
	
	Contact contact_2 = new Contact(852,"Tomer");
	Date date_2= new Date(2,14,2021);
	EventWithMeeting eventmeeting_2  = new EventWithMeeting(contact_2,54,date_2);
	calendar.addEvent(eventmeeting_2,book);
	calendar.printAccordingToADate(date);
	System.out.println("show the meeting just with Sarah because Tomer isn't in the PhoneBook"); 
	
	
	EventWithMeeting eventmeeting_3  = new EventWithMeeting(contact,53,date_2);
	calendar.addEvent(eventmeeting_3,book);
	calendar.printAccordingToAContact(contact);
	System.out.println("show the 2 meeting with Sarah\n ");
	
	calendar.printAllEvents();
	
	book.add(contact_2);
	Date date_4= new Date(2,14,2021);
	EventWithMeeting eventmeeting_4  = new EventWithMeeting(contact_2,54,date_4);
	calendar.addEvent(eventmeeting_4,book);
	calendar.printAllEvents();
	
	EventWithoutMeeting eventnomeeting  = new EventWithoutMeeting("hello",12,date_2);
	calendar.addEvent(eventnomeeting, book);
	calendar.printAllEvents();
	}
	
	
	
	
	
	
	
}
