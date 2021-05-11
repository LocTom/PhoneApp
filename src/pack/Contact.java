package pack;

public class Contact {
	int number;
	String name;
	String text;
	
	
	//Counstructor (makes contact)
	public Contact(int num, String nam)
	{
		number = num;
		name = nam;
		text = null;
	}
	
	void printName()
	{
		System.out.println(name);
	}
	
	//This method prints the contact
	void printContact()
	{
		System.out.println(name+", "+ number);
	}
	
	
	// The following methods are get mehtod
	String getContactName()
	{
		return name;
	}
	
	int getContactNumber()
	{
		return number;
	}
	

}