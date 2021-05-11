package matala2;

public class EventWithoutMeeting extends Event{

	String Description;
	
	public EventWithoutMeeting(String description, int time , DateTime dateTime) {
		super(time,dateTime);
		Description=description;
	}
	
	public String toString() {
		return(this.dateTime.toString()+" " + "the time is: "+this.time +" "+ this.Description);
	}
	
	
	public void print() {
		System.out.println(this.toString());
	}

	public Contact getContact() {
		return null;
	}
}
