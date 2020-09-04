package com.ffxiv;
import java.io.*;
import java.util.*;

public class Venues {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		ArrayList<VenueList> venues = new ArrayList<VenueList>();
		int ward = 0;
		int plot = 0;
		File sheet = new File("venues.csv");
		
		try {
		Scanner file = new Scanner(sheet);
		file.nextLine();
		while (file.hasNext()) {
			String temp = file.nextLine();
			String data[] = temp.split(",", 10);
			try {
			ward = Integer.parseInt(data[6]);
			plot = Integer.parseInt(data[7]);
			} catch (NumberFormatException e) {
				ward = 0;
				plot = 0;
			}
			VenueList temp2 = new VenueList(data[0], data[1], data[2], data[3], data[4], data[5], ward, plot, data[8], data[9]);
			venues.add(temp2);
			}
		
		file.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		while(input != 5) {
		do {
		System.out.println("Welcome to Crystal DC Venue Database"
				+"\nPlease make a selection: "
				+"\n1. Display all venues"
				+"\n2. Sort Alphabetically"
				+"\n3. Sort by Server"
				+"\n4. Add new"
				+"\n5. Exit");
		input = scan.nextInt();
		if(input <1 || input > 5) {
			System.out.println("Please make a valid selection: ");
		}
		
		
		switch(input) {
			case 1:
				printVenues(venues);
				break;
			case 2:
				Collections.sort(venues, VenueList.compName);
				printVenues(venues);
				break;
			case 3:
				Collections.sort(venues, VenueList.compServer);
				printVenues(venues);
				break;
			case 4:
				System.out.println("Please enter the following information or (?) if unknown");
				System.out.print("Venue name: ");
				String name = scan.next();
				scan.nextLine();
				System.out.print("Short description: ");
				String layout = scan.next();
				scan.nextLine();
				System.out.print("Venue type: ");
				String type = scan.next();
				scan.nextLine();
				System.out.print("World (Server) Location: ");
				String world = scan.next();
				scan.nextLine();
				System.out.print("Housing district: ");
				String housing = scan.next();
				scan.nextLine();
				System.out.print("Nearest Aetheryte: ");
				String aetheryte = scan.next();
				scan.nextLine();
				System.out.print("Ward: ");
				int wardTemp = scan.nextInt();
				scan.nextLine();
				System.out.print("Plot: ");
				int plotTemp = scan.nextInt();
				scan.nextLine();
				System.out.print("Open days: ");
				String days = scan.next();
				scan.nextLine();
				System.out.print("Hours: ");
				String hours = scan.next();
				scan.nextLine();
				VenueList toAdd = new VenueList(name, layout, type, world, housing, aetheryte, wardTemp, plotTemp, days, hours);
				venues.add(toAdd);
				System.out.println("Thank you for adding: \n");
				System.out.print(toAdd.toString());
				break;
			case 5:
				System.out.println("Thanks for using the Crystal DC Venue Database");
				break;
		} 
		}while (input < 1|| input > 5);
		}
		
		

	}
	private static void printVenues(ArrayList venues) {
		String output = venues.toString();
		output = output.replace("[", " ")
				.replaceAll(",", "")
				.replace("]", "");
		
		System.out.println(output);
	}
	private static void alphabetizeVen(ArrayList venues) {
		
	}

}
