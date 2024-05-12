package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static Dealership dealership;

    public static Dealership getDealership() {
        return dealership;
    }

    public static void userInterface() {
        System.out.println("Hello and Welcome to your local Dealership!");
        dealership = DealershipFileManager.getDealership();
        while (true) {
            try {
                System.out.println("""
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
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
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
                        processRemoveVehicle();
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
                        break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter your option in number format! ⚠----------");
            }
        }
    }

    public static void display(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("Vin: %s|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|Odometer: %d|Price: %.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getVehicleMake(), vehicle.getVehicleModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

    //method for price
    public static void processGetByPriceRequest() {
        while (true) {
            try {
                System.out.print("What would be the min price? $");
                double minPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("What would be the max price? $");
                double maxPrice = Double.parseDouble(scanner.nextLine());

                List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);

                display(vehiclesByPrice);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter price in number format! ⚠----------");
            }
        }
    }

    //method for make and model
    public static void processGetByMakeModelRequest() {
        while (true) {
            try {
                System.out.println("What would be the make and model of the car? ");
                System.out.print("Make: ");
                String vehicleMake = scanner.nextLine();
                System.out.print("Model: ");
                String vehicleModel = scanner.nextLine();

                List<Vehicle> vehiclesByMakeAndModel = dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);

                display(vehiclesByMakeAndModel);
                break;
            } catch (Exception exception) {
                System.out.println("----------⚠ Please try again! ⚠----------");
            }
        }
    }

    //method for year
    public static void processGetByYearRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by year range
    }

    //method for color
    public static void processGetByColorRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by color
    }

    //method for mileage
    public static void processGetByMileageRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by mileage range
    }

    //method for vehicle type
    public static void processGetByVehicleTypeRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to find vehicles by vehicle type
    }

    //method for displaying all vehicles
    public static void processGetAllVehicleRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to list all vehicle
    }

    //method for adding vehicles
    public static void processAddVehicleRequest(){
       throw new UnsupportedOperationException();
       //Method to process request to add a vehicle
    }

    //method for removing vehicles
    public static void processRemoveVehicle(){
       throw new UnsupportedOperationException();
       //Method to process request to remove a vehicle
    }

}
