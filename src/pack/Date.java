package pack;

public class Date {
	int month;
	int day;
	int year;
	
	//Counstructor (makes contact)
	public Date(int mon, int da, int ye)
	{
		month = mon;
		day = da;
		year = ye;
	}
	
	//This method prints the contact
	void printDate()
	{
		System.out.println(day+"/ "+ month + "/"+ year);
	}
	
	
	// The following methods are get mehtod
	int getDay()
	{
		return day;
	}
	
	int getMonth()
	{
		return month;
	}
	
	int getYear()
	{
		return year;
	}
}
