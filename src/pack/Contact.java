package pack;

public class Contact {
	int number;
	String name;
	
	//Counstructor (makes contact)
	public Contact(int num, String nam)
	{
		number = num;
		name = nam;
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
