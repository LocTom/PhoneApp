package pack;

 abstract public class Event implements Comparable<Event> {

	int time;
	Date date ;
	
	public Event(int timee, Date datee) {
		time=timee;
		date=datee;
	}
	 public abstract void print();
	 
	 public int compareTo(Event event) {
		 return this.date.compareTo(event.date);
	 }
	
	 public  abstract Contact getContact();
	
}
