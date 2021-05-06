package pack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*; 

class MediaApp implements App{
	
	 ArrayList<Media> mp4 = new ArrayList<Media>();

	
		public void add( String name,String type, Double length) 
		{
			if (type.equalsIgnoreCase("music")) 
			{
				Music m = new Music(name,length);
				mp4.add(m);
			}
			else {
				Video v = new Video(name,length);
				mp4.add(v);
				
			}
			
		}
		
	public void add() 
	{
		try {
			
		String name, type;
		double length;
		Scanner s = new Scanner(System.in);
		System.out.println("enter name of media\n");
		name = s.nextLine();
		System.out.println("enter length of media in minutes\n");
		length = s.nextDouble();
		s.nextLine(); //get rid of end of line symbol
		System.out.println("enter type of media music or video\n");
		type = s.nextLine();
		
		
		if (type.equalsIgnoreCase("music")) 
		{
			Music m = new Music(name,length);
			mp4.add(m);
		}
		else if (type.equalsIgnoreCase("video")){
			Video v = new Video(name,length);
			mp4.add(v);
			
		}
		else// didn't choose music/video
			throw new Exception("must be eather type 'music' or 'video'\n");
		}
		
		catch (InputMismatchException e) {
			System.out.println("please enter valid input\n");
		}
		catch (Exception e)// if didn't enter music/video
		{
			System.out.println(e.getMessage() + " please enter valid input\n");
		}
	
	
	}
		
	
	//play media by name
	public void play(String mediaName) {
		for (Media p:mp4) {
			if (p.name.equalsIgnoreCase(mediaName)) {
				System.out.println(p);
				if (p instanceof Music)
					System.out.println("of type Music\n");
				else
					System.out.println("of type Video\n");
				return;
		}
			
		}
		System.out.println("no such media");
	}
	
	public void playAll() {
		
	for (Media p:mp4) {
		System.out.println(p);
		if (p instanceof Music)
			System.out.println("of type Music\n");
		else
			System.out.println("of type Video\n");
		
	}
	}
	
	
public static void run(String args[]) {
		//Scanner scan1 = new Scanner(System.in);
		MediaApp playlist = new MediaApp();
		int a;

		
		while(true) 
		{
			Scanner scan = new Scanner(System.in);
			try
			{
				System.out.println("what you you like to do?\r\n"
					+"(1) Add a new media\r\n"
					+"(2) Play a media by name\r\n"
					+"(3) Play all media\r\n"
					+"(4) Exit\n");
			
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
		
	}//main

}//MediaApp

	



