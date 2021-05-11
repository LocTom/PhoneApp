package pack;

import java.util.*;

public class TestMobilePhone {
	
	public static void main(String[] args) {
		
		PhoneBook book = new PhoneBook(); // use the constructor of ArrayList<contact>
		Calendar calendar= new Calendar(book);
		Sms sms = new Sms(book);
		MediaApp media = new MediaApp();
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			try
			{
				System.out.println("what app you like to use?\r\n"
					+"(1) Phonebook\r\n"
					+"(2) Calander\r\n"
					+"(3) Sms\r\n"
					+"(4) Media\r\n"   
					+"(5) Exit\n");
			
			int a = scan.nextInt();// get users choice and call function accordingly 
			scan.nextLine();// get rid of EOL symbol
				
			switch(a) {
			case 1:// phonebook
				book.run();
				break;
			case 2:
				calendar.run();
				break;
			case 3:
				sms.run();
				break;
			case 4:
				media.run();
				break;
			case 5:
				scan.close();
				return;
			
			default:
				System.out.println("choose number 1-5");
			}
			}
			
			catch (Exception e)
			{
				System.out.println("Please enter a valid input\n");
			}
			
		}//while
			
				
		
			
			
	}

}
