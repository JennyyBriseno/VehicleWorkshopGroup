package org.example;

import java.util.ArrayList;
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

    //methods
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        throw new UnsupportedOperationException();
    }
    public List<Vehicle> getVehiclesByMakeModel(String make,String model){
        throw new UnsupportedOperationException();
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        throw new UnsupportedOperationException();
    }
    public List<Vehicle> getVehiclesByColor(String color){
        throw new UnsupportedOperationException();
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        throw new UnsupportedOperationException();
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
