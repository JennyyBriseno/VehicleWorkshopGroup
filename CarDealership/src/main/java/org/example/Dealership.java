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
        this.inventory = new ArrayList<>();
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
    // sorts array list by a price range then sorts them from min to max price
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

//         Sort the inventory list by price (ascending order)
        Collections.sort(vehiclesByPrice, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Double.compare(v1.getPrice(), v2.getPrice());
            }
        });

        return vehiclesByPrice;
    }

    // sorts array list by make and model sorts them from min to max price
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        // Initialize the list to store vehicles with the make and model specified
        List<Vehicle> vehicleMakeModel = new ArrayList<>();

        //Iterate through the list by make and model
        for (Vehicle vehicle : inventory) {
            if (make.equalsIgnoreCase(vehicle.getVehicleMake()) && model.equalsIgnoreCase(vehicle.getVehicleModel()))
                //add the vehicle to the list if its make and model is a match
                vehicleMakeModel.add(vehicle);
        }


        Collections.sort(vehicleMakeModel, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                int yearComparison = Integer.compare(v1.getYear(), v2.getYear());
                if (yearComparison != 0) {
                    return yearComparison;
                }

                return Double.compare(v1.getPrice(), v2.getPrice());
            }
        });
        return vehicleMakeModel;
    }

    // sorts array list by a year range then sorts them from min to max price
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        // Initialize the list to store vehicles within the year range
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

    // sorts array list by a color then sorts them by make, model then price from min to max price
    public List<Vehicle> getVehiclesByColor(String color) {
        //Initialize the list to store vehicles by the color specified
        List<Vehicle> vehiclesByColor = new ArrayList<>();

        //Iterate through the list
        for (Vehicle vehicle : inventory) {
            if (color.equalsIgnoreCase(vehicle.getColor())) {
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

    // sorts array list by a mileage range then sorts them from min to max mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        // Initialize the list to store vehicles within the mileage range
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

    // sorts array list by a vehicle type and sorts them by make, model then year
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicleType.equalsIgnoreCase(vehicle.getVehicleType())) {
                vehiclesByType.add(vehicle);
            }
        }
        Collections.sort(vehiclesByType, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                int makeComparison = v1.getVehicleMake().compareTo(v2.getVehicleMake());
                if (makeComparison != 0) {
                    return makeComparison;
                }

                int modelComparison = v1.getVehicleModel().compareTo(v2.getVehicleModel());
                if (modelComparison != 0) {
                    return modelComparison;
                }

                return Integer.compare(v1.getYear(), v2.getYear());
            }
        });
        return vehiclesByType;
    }

    //gets all vehicles
    public List<Vehicle> getAllVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            allVehicles.add(vehicle);
        }
        Collections.sort(allVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                int makeComparison = v1.getVehicleMake().compareTo(v2.getVehicleMake());
                if (makeComparison != 0) {
                    return makeComparison;
                }

                int modelComparison = v1.getVehicleModel().compareTo(v2.getVehicleModel());
                if (modelComparison != 0) {
                    return modelComparison;
                }

                return Integer.compare(v1.getYear(), v2.getYear());
            }
        });
        return allVehicles;
    }

    //adds a vehicle to the inventory array then rewrites the file
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        DealershipFileManager.saveDealership(UserInterface.getDealership());
    }

    //removes a vehicle from the inventory array then rewrites the file
    public void removeVehicle(int vin) {
        int counter = 0;
        for (Vehicle vehicle : inventory) {
            if (vin == vehicle.getVin()) {
                inventory.remove(vehicle);
                DealershipFileManager.saveDealership(UserInterface.getDealership());
                counter++;
                break;
            }
        }
        if (counter == 0) {
            System.out.println("Vehicle could not be found :( ");
        }
    }

    public Vehicle vehicleIsAvailable(int Vin) {
        for (Vehicle vehicleAvailable : inventory) {
            if (vehicleAvailable.getVin() == Vin) {
                return vehicleAvailable;
            }
        }
        return null;
    }
}

