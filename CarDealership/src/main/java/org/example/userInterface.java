package org.example;
import java.util.List;
public class userInterface {
   private Dealership dealership;
   public userInterface(Dealership dealership){
      this.dealership = dealership;
   }

    public void displayOption(){
        System.out.println("Welcome to the Dealership Application!");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List all vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
    }

    public void processGetByPriceRequest(){
       throw new UnsupportedOperationException();
       //Stub for processing get by price request
    }
    public void processGetByMakeModelRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by make/model
    }
    public void processGetByYearRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by year range
    }
    public void processGetByColorRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by color
    }
    public void processGetByMileageRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by mileage range
    }
    public void processGetByVehicleTypeRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by vehicle type
    }
    public void processGetAllVehicleRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to list all vehicle
    }
    public void processAddVehicleRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to add a vehicle
    }
    public void processRemoveVehicle(){
       throw new UnsupportedOperationException();
       //Method to process request to remove a vehicle
    }

}
