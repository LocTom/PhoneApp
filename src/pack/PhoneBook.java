package matala2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.io.*; 
import java.util.Scanner;
 public class PhoneBook extends ArrayList<Contact>{

	public static void main(PhoneBook book) 
	{
		//PhoneBook book = new PhoneBook();
		String name;
		int numb;
		while(true) {
			while(true) {
			Scanner scan = new Scanner(System.in);
			Scanner scan1 = new Scanner(System.in);
			System.out.println(
					"1. Add a contact \r\n"
					+ "2. Delete a contact by name\r\n"
					+ "3. Print all contacts to the screen\r\n"
					+ "4. Search for a contact by name\r\n"
					+ "5. Sort the phonebook by name\r\n"
					+ "6. Sort the phonebook by phone number\r\n"
					+ "7. Remove duplicates in the phonebook\r\n"
					+ "8. Arrange the phone book in reverse order\r\n"
					+ "9. Save the phonebook data in a text file \r\n"
					+ "10. Load the phone book data from a text file Add to existing phone book\r\n"
					+ "11. Exit\n");
			int a  = scan1.nextInt();// get users choice and call function accordingly 
			switch(a) 
			{
			case 1:
				System.out.println("enter a name:\n");
				name = scan.nextLine();
				System.out.println("enter a number:\n");
				numb = scan.nextInt();
				book.addContact(name, numb);
				book.printBook();
				break;	
			case 2:
				System.out.println("enter a name to earase:\n");
				name = scan.nextLine();
				book.eraseContact(name); 
				break;
			case 3:
				book.printBook();
				break;
			case 4:
				System.out.println("enter a name to search:\n");
				name = scan.nextLine();
				book.findContact(name);
				break;
			case 5:
				book.sortName();
				break;
			case 6:
				book.sortNumber();
				break;
			case 7:
				book.deleteDoubles();
				break;
			case 8:
				book.FlipBook();
				break;
			case 9:
				System.out.println("enter a name of file:\n");
				name = scan.nextLine();
				book.SaveBook(name);
				String path;
				try {
					path = new File(".").getCanonicalPath();
					System.out.println(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 10:
				System.out.println("enter a name of file:\n");
				name = scan.nextLine();
				book.fileReader(name);
				break;			
			case 11:
				break;	
				
			default:
				break; 
		  }				
		}
	  }
	}
		
	
	
	//this function adds a contact to the Phone book
	void addContact(String name, int number)
	{
		
		Contact a = new Contact(number,name);
		this.add(a);
	}
	
	
	//this function prints the whole phone book
	void printBook()
	{
		for(int i = 0; i < this.size(); i++)
		{
			this.get(i).printContact();
		}
	}
	
	//This is a comparator made to make the sort function be able to work by creating a comparator for the name
    public static Comparator<Contact> ContactNameComparator = new Comparator<Contact>() {

    	public int compare(Contact s1, Contact s2) {
		   String aName = s1.getContactName().toUpperCase();
		   String bName = s2.getContactName().toUpperCase();
	
		   //ascending order
		   return aName.compareTo(bName);
	
		  
    	}
    };
    
    //this function sorts the phone book by name
	void sortName()
	{
		Collections.sort(this, this.ContactNameComparator);
	}

	
	//This is a comparator made to make the sort function be able to work by creating a comparator for the number
    public static Comparator<Contact> ContactNumber = new Comparator<Contact>() {

		public int compare(Contact s1, Contact s2) {
	
		   int aNum = s1.getContactNumber();
		   int bNum = s2.getContactNumber();
	
		   //so its from big to small
		   return bNum-aNum;
	
		
		}
	};
	
    //this function sorts the phone book by number
	void sortNumber()
	{
		Collections.sort(this, this.ContactNumber);
	}

	// save the book in a file 
	void SaveBook(String fileName)
		{
			File f = new File(fileName);
			
			FileWriter writer;
			
			try {
				writer = new FileWriter(f);
				for(int i = 0; i < this.size(); i++)
				{
				writer.write(this.get(i).getContactName());
				writer.write(",");
				writer.write(Integer.toString(this.get(i).getContactNumber()));
				writer.write("\n");
				}
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	//this finction returns all contacts with chosen name 
	public Contact findContact(String name)
	{
		System.out.println("in FindContact");
		String name1;
		name = name.toUpperCase();
		for(int i = 0; i < this.size(); i++)
		{
			name1 = this.get(i).getContactName().toUpperCase();

			if (name.equalsIgnoreCase(name1)) {
				System.out.println("found contact");
				System.out.println(this.get(i));
				Contact contact = this.get(i);
				return contact;  	
				
			}
			 	 		 
		} 
		return null;
	}

	//this function erases a single contact by name
		void eraseContact(String name) 
		{

			for(int i = 0; i < this.size(); i++)
			{
			    String n = this.get(i).getContactName();
				if(n.equalsIgnoreCase(name))
				{
					this.remove(i);
					break;
				}
			
			}
			
		}
		
		
		//deletes doubles in contacts
		//deletes doubles in contacts
		//deletes doubles in contacts
		public void deleteDoubles() {
	        for (int j = 0; j < this.size()-1; j++) {
	            for (int i = j+1; i < this.size(); i++) {
	                if (this.get(i).equals(this.get(j))) {
	                    this.remove(i);
	                    i--;
	                }
	            }
	        }
	    }
				
		//this function writes phone book contents into a chosen file
		void fileReader(String filename) 
		{

		try (Scanner s = new Scanner(new FileReader(filename))) {   
		    while (s.hasNext()) { 
		    	String name = s.nextLine(); // read name untill space
		    	String str[] = name.split(",");
		    	String nam = str[0]; 
		    	int number = Integer.parseInt(str[1]); // read number untill space
		        this.addContact(nam, number);
		
		    }		    
		    
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		//this function reverses the book
		void FlipBook()
		{
			  Collections.reverse(this);
		}	
		
		
}
		
