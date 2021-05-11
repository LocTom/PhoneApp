package pack;

public class DateTime implements Comparable<DateTime>{
	Date date;
	int hour;
	int min;
	int sec;
	
	//Counstructor (makes contact)
	public DateTime(int mon, int da, int ye,int hourr, int minu,int seco)
	{
		date = new Date(mon, da, ye);
		hour=hourr;
		min=minu;
		sec=seco;
		
	}

	//This method prints the contact
	void printDateTime()
	{
		System.out.println(this.toString());
	}

	public String toString() {
		return date.toString() + " " + hour + ":" + min + ":" + sec;
	}

	public int compareTo(DateTime dateTime) {
		if(this.date.compareTo(dateTime.date) != 0) {
			return this.date.compareTo(dateTime.date);
		}
		if(this.hour!=dateTime.hour) {
			return dateTime.hour-this.hour;} 
		if(this.min!=dateTime.min) {
			return dateTime.min-this.min;}
		if(this.sec!=dateTime.sec) {
			return dateTime.sec-this.sec;
		}
		return 0;
}
}