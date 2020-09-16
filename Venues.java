package com.ffxiv;
import java.io.*;
import java.util.*;
import java.time.*;

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
		printVenues(venues);
		while(input != 5) {
		do {
		System.out.println("Welcome to Crystal DC Venue Database"
				+"\nPlease make a selection: "
				+"\n1. Sort Alphabetically"
				+"\n2. Sort by Server"
				+"\n3. Add new"
				+"\n4. Remove"
				+"\n5. Save and exit");
		input = scan.nextInt();
		if(input <1 || input > 5) {
			System.out.println("Please make a valid selection: ");
		}
		
		switch(input) {
			case 1:
				Collections.sort(venues, VenueList.compName);
				printVenues(venues);
				break;
			case 2:
				Collections.sort(venues, VenueList.compName);
				Collections.sort(venues, VenueList.compServer);
				printVenues(venues);
				break;
			case 3:
				System.out.println("Please enter the following information or (?) if unknown");
				System.out.print("Venue name: ");
				String name = scan.nextLine();
				name = scan.nextLine();
				for(int i = 0; i < venues.size(); i++) {
					if ((name.toLowerCase().equals(venues.get(i).getName().toLowerCase()))){
						System.out.println("Venue already exists in database");
						break;
					}
				}
				System.out.print("Short description: ");
				String layout = scan.nextLine();
				System.out.print("Venue type: ");
				String type = scan.nextLine();
				System.out.print("World (Server) Location: ");
				String world = scan.nextLine();
				System.out.print("Housing district: ");
				String housing = scan.nextLine();
				System.out.print("Nearest Aetheryte: ");
				String aetheryte = scan.nextLine();
				System.out.print("Ward: ");
				String wardTemp = scan.nextLine();
				System.out.print("Plot: ");
				String plotTemp = scan.nextLine();
				System.out.print("Open days: ");
				String days = scan.nextLine();
				System.out.print("Hours: ");
				String hours = scan.nextLine();
				if (wardTemp.equals("?")) {
					wardTemp = "-1";
				}
				if (plotTemp.equals("?")) {
					plotTemp = "-1";
				}
				VenueList toAdd = new VenueList(name, layout, type, world, housing, aetheryte, Integer.parseInt(wardTemp), Integer.parseInt(plotTemp), days, hours);
				venues.add(toAdd);
				System.out.println("Thank you for adding: \n");
				System.out.print(toAdd.toString());
				break;
				
			case 4:
				System.out.print("Enter name of venue: ");
				String venDel = scan.nextLine();
				venDel = scan.nextLine();
				for(int i = 0; i<venues.size(); i++) {
					if(venDel.equalsIgnoreCase(venues.get(i).getName())) {
						System.out.println("Are you sure you wish to remove: \n" + venues.get(i).toString()
								+"\n1. Yes"
								+"\n2. No");
						int choice = scan.nextInt();
						scan.nextLine();
						if(choice == 1) {
						venues.remove(i);
						}
					}
					
				}
				break;
			case 5:
				FileWriter output = null;
				
				try
				{
					Collections.sort(venues, VenueList.compName);
					Collections.sort(venues, VenueList.compServer);
					output = new FileWriter("venues-" + LocalDate.now() + ".csv");
					output.append("Name of Venue, Description/Layout, Type of Place, Server, Housing, Aetheryte, Ward, Plot, Day, Time(EST)\n");
					for(int i = 0; i<venues.size(); i++) {
					output.append(venues.get(i).csvOutput()+ "\n");
					}
					output.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				System.out.println("Thanks for using the Crystal DC Venue Database");
				break;
		} 
		}while (input < 1|| input > 5);
		}
		
		scan.close();

	}
	private static void printVenues(ArrayList<VenueList> venues) {
		String output = venues.toString();
		output = output.replace("[", " ")
				.replaceAll(",", "")
				.replace("]", "");
		
		System.out.println(output);
	}
	
}
