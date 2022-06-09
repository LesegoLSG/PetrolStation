import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<PetrolStation> readPetrolStationsFromDB(String path){
		ArrayList<PetrolStation> petrolStations = new ArrayList<PetrolStation>();
		File dbfile = new File(path);
		
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbfile));
			int counter =0;
			try{
				while(true){
					PetrolStation petrolStation = (PetrolStation) ois.readObject();
					petrolStations.add(counter,petrolStation);
					counter++;
				}
				
			}catch(EOFException e){
				System.out.println("end of file");
			}
			ois.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return petrolStations;
	}
	
	public static PetrolStation calculateClosestPetrolStation(ArrayList<PetrolStation> list, GPSPoint currentLocation){
		PetrolStation petStation = null;
		double closeLoc = list.get(0).getLocation().calculateDistance(currentLocation);
		
		for(PetrolStation pStation : list ){
			double mini = pStation.getLocation().calculateDistance(currentLocation);
			if(mini < closeLoc){
				closeLoc = mini;
				petStation = pStation;
			}
		}
		return petStation;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<PetrolStation> list = readPetrolStationsFromDB("petrolstations.db");
		
		PetrolStation p1 = new PetrolStation("Shell Boskruin Motors","Features: Vida e cafe; Debonnairs Pizza", new GPSPoint(27.959148,-2091459));
		list.add(0,p1);
		PetrolStation p2 = new PetrolStation("Sasol Randburg", "Features:Absa ATM", new GPSPoint(27.990038,-26.110212));
		list.add(0,p2);
		
		System.out.println(list.size() + " petrol stations loaded");
		
		Scanner scan = new Scanner(System.in);
		String gps = "";
		while(!gps.toLowerCase().equals("q")){
			System.out.println("Enter your GPS coordinates in the long:lat format ('q' to quit): ");
			gps = scan.nextLine();
			if(gps.toLowerCase().equals("q"))
				break;
			double longitude = Double.parseDouble(gps.split(":")[0]);
			double latitude = Double.parseDouble(gps.split(":")[1]);
			GPSPoint currentLocation = new GPSPoint(longitude,latitude);
			System.out.println("The closest petrol station to " + currentLocation + " is: \n" + calculateClosestPetrolStation(list,currentLocation));
		}
		scan.close();
	}

}
