package org.example;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //properties
    private static final Scanner scanner = new Scanner(System.in);

    private static Dealership dealership;

    //getter
    public static Dealership getDealership() {
        return dealership;
    }

    //Programs main screen
    public static void userInterface() {
        System.out.println("Hello and Welcome to your local Dealership!");
        //instantiate the dealership
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
                        10)Purchase a car
                        0)Quit""");
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
                        System.out.println("Please enter the vehicle vin you would like to remove: ");
                        processRemoveVehicle();
                        break;
                    case 0:
                        System.out.println("""
                                ----------⚠ EXITING APPLICATION ⚠----------
                                 ----------HOPE TO SEE YOU SOON!----------
                                """);
                        System.exit(0);
                        break;
                    case 10:
                        System.out.println("Please answer the following questions: ");
                        purchaseAVehicle();
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

    //method to display the sorted array lists of vehicles
    public static void display(List<Vehicle> vehicles) {
        int counter = 0;
        for (Vehicle vehicle : vehicles) {
            System.out.printf("Vin: %s|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|Odometer: %d|Price: %.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getVehicleMake(), vehicle.getVehicleModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            counter++;
        }
        if (counter == 0) {
            System.out.println("Sorry, no vehicles were found :( ");
        }
        System.out.printf("This is the total amount of vehicles displayed: %d\n", counter);
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

    //Method to process request to find vehicles by year range
    public static void processGetByYearRequest() {
        while (true) {
            try {
                System.out.print("What would be the min year? ");
                int minYear = Integer.parseInt(scanner.nextLine());
                System.out.print("What would be the max year? ");
                int maxYear = Integer.parseInt(scanner.nextLine());

                List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);

                display(vehiclesByYear);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter year in number format! ⚠----------");
            }
        }
    }

    //method for color
    public static void processGetByColorRequest() {
        while (true) {
            try {
                System.out.println("What color would you like to sort by? ");
                String vehicleColor = scanner.nextLine();

                List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(vehicleColor);

                display(vehiclesByColor);
                break;
            } catch (Exception exception) {
                System.out.println("----------⚠ Please try again! ⚠----------");
            }
        }
    }

    //method for mileage
    public static void processGetByMileageRequest() {
        while (true) {
            try {
                System.out.print("What would be the min mileage? ");
                int minMileage = Integer.parseInt(scanner.nextLine());
                System.out.print("What would be the max mileage? ");
                int maxMileage = Integer.parseInt(scanner.nextLine());

                List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
                display(vehiclesByMileage);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter the mileage in number format! ⚠----------");
            }
        }
    }

    //method for vehicle type
    public static void processGetByVehicleTypeRequest() {
        while (true) {
            try {
                System.out.print("What would be the type of vehicle you are looking for? ");
                String vehicleType = scanner.nextLine();

                List<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);

                display(vehiclesByType);
                break;
            } catch (Exception exception) {
                System.out.println("----------⚠ Please try again! ⚠----------");
            }
        }
    }

    //method for displaying all vehicles
    public static void processGetAllVehicleRequest() {
        display(dealership.getAllVehicles());
    }

    //method for adding vehicles
    public static void processAddVehicleRequest() {
        while (true) {
            try {
                System.out.print("Please enter the vin: ");
                int vehicleVin = Integer.parseInt(scanner.nextLine());

                System.out.print("Please enter the year? ");
                int vehicleYear = Integer.parseInt(scanner.nextLine());

                System.out.print("Please enter the vehicle make: ");
                String vehicleMake = scanner.nextLine();

                System.out.print("Please enter the vehicle model: ");
                String vehicleModel = scanner.nextLine();

                System.out.print("Please enter the vehicle type: ");
                String vehicleType = scanner.nextLine();

                System.out.print("Please enter the vehicle color: ");
                String vehicleColor = scanner.nextLine();

                System.out.print("Please enter the vehicle's odometer: ");
                int vehicleOdometer = Integer.parseInt(scanner.nextLine());

                System.out.print("Please enter the vehicle price: ");
                double vehiclePrice = Double.parseDouble(scanner.nextLine());

                Vehicle addedVehicle = new Vehicle(vehicleVin, vehicleYear, vehicleModel, vehicleMake, vehicleType, vehicleColor, vehicleOdometer, vehiclePrice);
                dealership.addVehicle(addedVehicle);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter valid information! ⚠----------");
            }
        }
    }

    //method for removing vehicles
    public static void processRemoveVehicle() {
        while (true) {
            try {
                System.out.print("Please enter the vin: ");
                int vehicleVin = Integer.parseInt(scanner.nextLine());

                dealership.removeVehicle(vehicleVin);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter a number! ⚠----------");
            }
        }
    }

    public static void purchaseAVehicle() {
        while (true) {
            try {
                System.out.println("""
                        Please select an option for contract !
                        1)Buy a vehicle
                        2)Lease a vehicle
                        """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        buyAVehicle();
                        userInterface();
                        break;
                    case 2:
                        leaseAVehicle();
                        userInterface();
                        break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter your option in number format! ⚠----------");
            }
        }
    }

    public static void buyAVehicle() {
        while (true) {
            try {
                System.out.print("Please enter the date MM/DD/YYYY: ");
                String date = scanner.nextLine();
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Please enter a valid email address: ");
                String emailAddress = scanner.nextLine();
                boolean finance = true;
                System.out.print("Please enter the vin of the vehicle you would like to purchase: ");
                int vehicleVin = Integer.parseInt(scanner.nextLine());
                System.out.println("Would you be interested in the finance option: ");
                String financeOption = scanner.nextLine();
                if (financeOption.equalsIgnoreCase("No")) {
                    finance = false;
                }

                Vehicle vehicle = dealership.vehicleIsAvailable(vehicleVin);
                Contract contract = new SalesContract(date, name, emailAddress, vehicle, finance);
                ContractFileManager.writeToContractFile(contract);
                dealership.removeVehicle(vehicleVin);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter a number! ⚠----------");
            }
        }
    }

    public static void leaseAVehicle() {
        while (true) {
            try {
                System.out.print("Please enter the date MM/DD/YYYY: ");
                String date = scanner.nextLine();

                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                System.out.print("Please enter a valid email address: ");
                String emailAddress = scanner.nextLine();

                System.out.print("Please enter the vin of the vehicle you would like to purchase: ");
                int vehicleVin = Integer.parseInt(scanner.nextLine());

                Vehicle vehicle = dealership.vehicleIsAvailable(vehicleVin);
                Contract contract = new LeaseContract(date, name, emailAddress, vehicle);
                ContractFileManager.writeToContractFile(contract);
                dealership.removeVehicle(vehicleVin);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("----------⚠ Please enter a number! ⚠----------");
            }
        }
    }
}