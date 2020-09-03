package com.ffxiv;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.lang.*;

public class Venues {

	public static void main(String[] args) {
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
			for(int i = 0; i<10; i++) {
				System.out.print(data[i] + " ");
				if (i==9){
					System.out.println("\n");
				}
			}
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
		
		//System.out.print("Name" + "Description" + "Type" + "Server" +  "Housing" + "Aetheryte" + "Ward" + "Plot" + "Day" + "Time");
		String output = venues.toString();
		output = output.replace("[", "")
				.replaceAll(",", "")
				.replace("]", "");
		
		System.out.println(output);
		

	}

}
