package org.example;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class userInterface {
    private static final Scanner scanner = new Scanner(System.in);
   private Dealership dealership;
   public userInterface(Dealership dealership){
      this.dealership = dealership;
   }
   public void userInterface(){
       throw new UnsupportedOperationException();
   }
   public void displayOptions(){
       System.out.println("""
                                    Hello and Welcome to your local Dealership!
                            What can we do for you today?
                            1)Display vehicles by price range!
                            2)Display vehicles by make and model!
                            3)Display vehicles by year!
                            4)Display vehicles by color!
                            5)Display vehicles by mileage
                            6)Display vehicles by vehicle type!
                            7)Display all vehicles!
                            8)Add a vehicle
                            9)Remove a vehicle
                            """);
       int choice = scanner.nextInt();
       switch(choice){
           case 1:
               System.out.println("Please answer the following questions: ");
               processGetByPriceRequest();
               break;
           case 2:
               System.out.println("Please answer the following questions: ");
               processGetByMakeModelRequest();
               break;
           case 3:
               System.out.println("Please answer the following questions: ");
               processGetByYearRequest();
               break;
           case 4:
               System.out.println("Please answer the following questions: ");
               processGetByColorRequest();
               break;
           case 5:
               System.out.println("Please answer the following questions: ");
               processGetByMileageRequest();
               break;
           case 6:
               System.out.println("Please answer the following questions: ");
               processGetByVehicleTypeRequest();
               break;
           case 7:
               System.out.println("Here is a list of all vehicles! ");
               processGetAllVehicleRequest();
               break;
           case 8:
               System.out.println("Please answer the following questions: ");
               processAddVehicleRequest();
               break;
           case 9:
               System.out.println("Please answer the following questions: ");
               break;
           case 0:
               System.out.println("""
                                    ----------⚠ EXITING APPLICATION ⚠----------
                                     ----------HOPE TO SEE YOU SOON!----------
                                    """);
               System.exit(0);
               break;
           default:
               System.out.println("----------⚠ Sorry that is not an option! Try again! ⚠----------");
               displayOptions();
               break;
       }
   }

    public void displayOption(){
       throw new UnsupportedOperationException();
       //Method to display options to the user
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
