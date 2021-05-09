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
	
	void add(String name, String txt){	
		
		int i = 0;
		for (i=0; i<book.size(); i++){
			if (book.get(i).getContactName().toUpperCase().equalsIgnoreCase(name)) {
				book.get(i).text = book.get(i).text+txt;
				System.out.println("chat has been added");
				return;
			}
			else 
				system.out.ln("Contact does not exist");
		}
	}	
	
	public void run(){
		//Scanner scan1 = new Scanner(System.in);
		MediaApp playlist = new MediaApp();
		int a;

		
		while(true) 
		{
			Scanner scan = new Scanner(System.in);
			try
			{
				System.out.println("what you you like to do?\r\n"
					+"(1) Add a new chat\r\n"
					+"(2) Erase a chat\r\n"
					+"(3) Print a chat by contacts name\r\n"
					+"(4) Search by sentence\r\n"	   
					+"(5) Exit\n");
			
			a = scan.nextInt();// get users choice and call function accordingly 
			scan.nextLine();// get rid of EOL symbol
			
			switch(a) 
			{
			case 1://add new media
				playlist.add();
				break;
			case 2://play media by name
				System.out.println("enter name of media\n");
				String mName = scan.nextLine();
				playlist.play(mName);
				break;
			case 3://play all media
				playlist.playAll();
				break;
			case 4:
				scan.close();
				return;
				
			default:
				System.out.println("choose an option between 1-4\n");
			}//try
			
			}// switch case
			catch (Exception e)
			{
				System.out.println(" please enter a valid input\n");
			}
			

	}// while
		
	}//run

	

	void delete_chat(String name){		
		int i = 0;
		for (i=0; i<book.size(); i++){
			if (book.get(i).getContactName().toUpperCase().equalsIgnoreCase(name)){
				book.get(i).text = null;
				System.out.println("conversation has been deleted");
				return;
				}
		}
	}

	void printConvByName(String name) {
		int i=0;
		for (i=0; i<book.size(); i++){
			if (book.get(i).getContactName().toUpperCase().equalsIgnoreCase(name)) {
				System.out.println(book.get(i).text);
				return;
			}
		}
	}
	
	void search_string(String str) {
		int i = 0;
		for (i=0; i<book.size(); i++){
			if(book.get(i).text.contains(str))
				book.get(i).printName();	
		}
		
		
	}

	void printAll() {
		
		int i = 0;
		for (i=0; i<book.size(); i++){
				book.get(i).printName();
				System.out.println(":\n");
				System.out.println(book.get(i).text);
				System.out.println("\n");
		}
		
		
	}
	
	
	
}
