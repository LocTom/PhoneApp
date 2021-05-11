package pack;

public class TestMobilePhone {
	
	public static void main(String[] args) {
		
		PhoneBook book = new PhoneBook(); // use the constructor of ArrayList<contact>
		Calendar calendar= new Calendar(book);
		Sms sms = new Sms(book);
		Media media = new Media();
		
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
			
			a = scan.nextInt();// get users choice and call function accordingly 
			scan.nextLine();// get rid of EOL symbol
				
			switch(a):
			case 1:// phonebook
				book.run();
				break;
			case 2:
				calendar.run();
				break;
			case(3):
				sms.run();
				retun;
			case(4):
				media.run();
				retun;
			case5:
				return;
			
			default:
				system.out.println("choose number 1-5");
			}
			catch (Exception e)
			{
				System.out.println("Please enter a valid input\n");
			}
			
				
			
			
			
			
		}
		

		
		

	}

}
