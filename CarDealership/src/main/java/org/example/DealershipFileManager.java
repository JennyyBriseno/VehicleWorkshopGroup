package org.example;

import java.util.ArrayList;

public class DealershipFileManager {

    //Read the file
    public static Dealership getDealership(){
        Dealership dealership = new Dealership("name of dealership","address of dealership", "dealership phone number");
        //Loop through vehicles in file
        //Create an arraylist
        //do dealership.setInventory, pass in the arraylist of vehicles
        return dealership;
    }

    //Write to the file
    public static void saveDealership(Dealership dealership){
        throw new UnsupportedOperationException();
    }
}
