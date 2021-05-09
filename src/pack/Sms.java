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
