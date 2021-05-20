package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.io.*; 
import java.util.Scanner;

public class Sms implements App {
	
	PhoneBook book;
	
	public Sms(PhoneBook a){
		
		book = a;
	}
	
	public void add(String name, String txt){	
		
		int i = 0;
		for (i=0; i<book.size(); i++){
			if (book.get(i).getContactName().toUpperCase().equalsIgnoreCase(name)) {
				book.get(i).text = book.get(i).text+txt;
				System.out.println("chat has been added");
				return;
			}
			else 
				System.out.println("Contact does not exist");
		}
	}	
	
	

	public void delete_chat(String name){		
		int i = 0;
		for (i=0; i<book.size(); i++){
			if (book.get(i).getContactName().toUpperCase().equalsIgnoreCase(name)){
				book.get(i).text = null;
				System.out.println("conversation has been deleted");
				return;
				}
		}
	}

	public void printConvByName(String name) {
		
		for (int i=0; i<book.size(); i++){
			if (book.get(i).getContactName().toUpperCase().equalsIgnoreCase(name)) {
				System.out.println(book.get(i).text);
				return;
			}
		}
	}
	
	public void search_string(String str) {
		int i = 0;
		for (i=0; i<book.size(); i++){
			if(book.get(i).text.contains(str))
				book.get(i).printName();	
		}
		
		
	}

	public void printAll() {
		
		int i = 0;
		for (i=0; i<book.size(); i++){
				book.get(i).printName();
				System.out.println(":\n");
				System.out.println(book.get(i).text);
				System.out.println("\n");
		}
		
		
	}
	
	
	


	public void run(){
			MediaApp playlist = new MediaApp();
			int a;

			while(true) 
			{
				try
				{
				if(book.isEmpty()) 
				{
						throw new Exception("Phonebook is empty\n");
				}
				
				Scanner scan = new Scanner(System.in);
				
					System.out.println("What you you like to do?\r\n"
						+"(1) Add a new chat\r\n"
						+"(2) Erase a chat\r\n"
						+"(3) Print a chat by contacts name\r\n"
						+"(4) Search by sentence\r\n"	
						+"(5) Print all chats\r\n"	   
						+"(6) Exit\n");
					
				
				a = scan.nextInt();// get users choice and call function accordingly 
				scan.nextLine();// get rid of End Of Line symbol
				String name;
				switch(a) 
				{
				case 1://add new chat
					System.out.println("Enter name of contanct\n");
					name = scan.nextLine();
					System.out.println("Enter sms\n");	
					String txt = scan.nextLine();	
					this.add(name,txt);
					break;
				case 2://delete chat
					System.out.println("Enter name of contacts chat you want to delete\n");
					name = scan.nextLine();
					this.delete_chat(name);
					break;
				case 3://print contacts chat
					System.out.println("Enter name of contacts chat you want to print\n");
					name = scan.nextLine();
					this.printConvByName(name);
					break;
				case 4:// search chat by sentence 
					System.out.println("Enter sentence you want to search for\n");
					String sent = scan.nextLine();	
					this.search_string(sent);
					break;
				case 5:
					this.printAll();
					break;
				case 6:
					return;

				default:
					System.out.println("Choose an option between 1-6\n");
				}//try

				}// switch case
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					return;
				}


			}// while

		}//run

}// class
