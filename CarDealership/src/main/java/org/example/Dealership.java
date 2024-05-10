package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    //properties
    private String name;
    private String address;
    private String phone;

    List<Vehicle> inventory = new ArrayList<>();

    //constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    //methods
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        // Initialize the list to store vehicles within the price range
        List<Vehicle> vehiclesByPrice = new ArrayList<>();

        // Iterate through the sorted inventory list
        for (Vehicle vehicle : inventory) {
            double price = vehicle.getPrice();
            if (price >= min && price <= max) {
                // Add the vehicle to the list if its price falls within the range
                vehiclesByPrice.add(vehicle);
            }
        }

        // Sort the inventory list by price (ascending order)
        Collections.sort(vehiclesByPrice, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Double.compare(v1.getPrice(), v2.getPrice());
            }
        });

        return vehiclesByPrice;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make,String model){
        throw new UnsupportedOperationException();
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        // Initialize the list to store vehicles within the price range
        List<Vehicle> vehiclesByYear = new ArrayList<>();

        // Iterate through the sorted inventory list
        for (Vehicle vehicle : inventory) {
            int year = vehicle.getYear();
            if (year >= min && year <= max) {
                vehiclesByYear.add(vehicle);
            }
        }

        // Sort the inventory list by year (ascending order)
        Collections.sort(vehiclesByYear, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getYear(), v2.getYear());
            }
        });

        return vehiclesByYear;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        //Initialize the list to store vehicles by the color specified
        List<Vehicle> vehiclesByColor = new ArrayList<>();

        //Iterate through the list
        for(Vehicle vehicle : inventory){
            if(color.equalsIgnoreCase(vehicle.getColor())){
                vehiclesByColor.add(vehicle);

            }
        }
        Collections.sort(vehiclesByColor, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                // First compare by make
                int makeComparison = v1.getVehicleMake().compareTo(v2.getVehicleMake());
                if (makeComparison != 0) {
                    return makeComparison; // If makes are different, return the comparison result
                }

                // If makes are the same, compare by model
                int modelComparison = v1.getVehicleModel().compareTo(v2.getVehicleModel());
                if (modelComparison != 0) {
                    return modelComparison; // If models are different, return the comparison result
                }

                // If models are the same, compare by price
                return Double.compare(v1.getPrice(), v2.getPrice());
            }
        });
        return vehiclesByColor;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        // Initialize the list to store vehicles within the price range
        List<Vehicle> vehiclesByMileage = new ArrayList<>();

        // Iterate through the sorted inventory list
        for (Vehicle vehicle : inventory) {
            int mileage = vehicle.getOdometer();
            if (mileage >= min && mileage <= max) {
                vehiclesByMileage.add(vehicle);
            }
        }

        // Sort the inventory list by year (ascending order)
        Collections.sort(vehiclesByMileage, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Integer.compare(v1.getOdometer(), v2.getOdometer());
            }
        });

        return vehiclesByMileage;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        throw new UnsupportedOperationException();
    }
    public List<Vehicle> getAllVehicles(){
        throw new UnsupportedOperationException();
    }
    public void addVehicle(Vehicle vehicle){
        throw new UnsupportedOperationException();
    }
    public void removeVehicle(Vehicle vehicle){
        throw new UnsupportedOperationException();
    }
}
