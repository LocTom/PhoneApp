package pack;

public class Date implements Comparable<Date>{
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
	void printdate()
	{
		System.out.println(this.toString());
	}

	public String toString() {
		return("the date is: " +day+"/"+ month + "/"+ year);
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
	
	public boolean equals(Date date) {
		return year == date.year && month == date.month && day == date.day;
	}
	
	public int compareTo(Date date) {
		if(this.year!=date.year) {
			return date.year-this.year;} 
		if(this.month!=date.month) {
			return date.month-this.month;}
		if(this.day!=date.day) {
			return date.day-this.day;
		}
		return 0;
}
}