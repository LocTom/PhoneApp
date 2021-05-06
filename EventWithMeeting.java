package pack;

public class EventWithMeeting extends Event {
	
	Contact contact;
	
	public EventWithMeeting(Contact contacte, int time , Date date) {
		super(time,date);
		contact=contacte;
	}
	
	public String toString() {
		return(this.date.toString()+" " + "the time is: "+this.time +" "+ this.contact.toString());
	}
	
	
	public void print() {
		System.out.println(this.toString());
	}

	public Contact getContact() {
		return contact;
	}
	
}
