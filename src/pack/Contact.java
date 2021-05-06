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
	
	public String toString() {
		return ("the name of the contact is: "+name+", and his number is "+ number);
	}
	
	//This method prints the contact
	void printContact()
	{
		System.out.println(this.toString());
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