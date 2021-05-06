package pack;

public class EventWithoutMeeting extends Event{

	String Description;
	
	public EventWithoutMeeting(String description, int time , Date date) {
		super(time,date);
		Description=description;
	}
	
	public String toString() {
		return(this.date.toString()+" " + "the time is: "+this.time +" "+ this.Description);
	}
	
	
	public void print() {
		System.out.println(this.toString());
	}

	public Contact getContact() {
		return null;
	}
}
