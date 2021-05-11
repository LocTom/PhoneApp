package matala2;

public class EventWithMeeting extends Event {
	
	Contact contact;
	
	public EventWithMeeting(Contact contacte, int time , DateTime dateTime) {
		super(time,dateTime);
		contact=contacte;
	}
	
	public String toString() {
		return(this.dateTime.toString()+" " + "the time is: "+this.time +" "+ this.contact.toString());
	}
	
	
	public void print() {
		System.out.println(this.toString());
	}

	public Contact getContact() {
		return contact;
	}
	
}
