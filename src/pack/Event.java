package pack;

public class Event extends Date{
	Date date;
	String name;

	//Counstructor (makes event)
	public Event(int mon,int da,int ye, String nam) //have an issue here trying to figrue out how to do this constructor
	{
		date= new Date(mon,da,ye);
		name = nam;
	}
	
	//This method prints the contact
	void printEvent()
	{
		System.out.println(name+", "+ date);
	}
	
	
	// The following methods are get mehtod
	String getEventName()
	{
		return name;
	}
	
	Date getEventDate()
	{
		return date;
	}
}
