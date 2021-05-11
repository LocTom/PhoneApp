package matala2;

 abstract public class Event implements Comparable<Event> {

	int time;
	DateTime dateTime ;
	
	public Event(int timee, DateTime dateTimee) {
		time=timee;
		dateTime=dateTimee;
	}
	 public abstract void print();
	 
	 public int compareTo(Event event) {
		 return event.dateTime.compareTo(this.dateTime);
	 }
	
	 public  abstract Contact getContact();
	
}
