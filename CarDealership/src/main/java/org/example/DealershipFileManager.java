package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {
        private static final String filePath = "src/main/resources/inventory.csv";
        private static final Scanner scanner = new Scanner(System.in);
        private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

        //Read the file
        public static Dealership getDealership(){
            Dealership dealership = new Dealership("Great Motors Co.","3449 Runaway St", "469-822-7861");

            //Loop through vehicles in file
            try(FileReader fileReader = new FileReader(filePath)){
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                reader.readLine();
                while((line = reader.readLine()) != null) {
                    String[] data = line.split("\\|");
                    int vin = Integer.parseInt(data[0]);
                    int year = Integer.parseInt(data[1]);
                    String vehicleModel = data[2];
                    String vehicleMake = data[3];
                    String vehicleType = data[4];
                    String color = data[5];
                    int odometer = Integer.parseInt(data[6]);
                    double price = Double.parseDouble(data[7]);

                    Vehicle vehicle = new Vehicle(vin, year, vehicleModel, vehicleMake, vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                }
            }
            catch (IOException e){
                System.out.println("File not found");
            }

            dealership.setInventory(vehicles);
            return dealership;
        }
    //Write to the file
    public static void saveDealership(Dealership dealership){
        throw new UnsupportedOperationException();
    }
}
