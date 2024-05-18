package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.rmi.dgc.Lease;

public class ContractFileManager {
    private static final String filePath = "src/main/resources/contracts.csv";


    public static void writeToContractFile(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                writer.write(String.format("SALE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getVehicleSold().toString(),
                        salesContract.getSalesTaxAmount(),
                        salesContract.getRecordingFee(),
                        salesContract.getProcessingFee(),
                        contract.getTotalPrice(),
                        (salesContract.isFinanceOption() ? "YES" : "No"),
                        contract.getMonthlyPayment()) + "\n");
                writer.newLine();
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write(String.format("LEASE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f",
                    contract.getDate(),
                    contract.getCustomerName(),
                    contract.getCustomerEmail(),
                    contract.getVehicleSold().toString(),
                    leaseContract.getExpectedEndingValue(),
                    leaseContract.getLeaseFee(),
                    contract.getTotalPrice(),
                    contract.getMonthlyPayment()));
                writer.newLine();
            }
        } catch (IOException ex) {
            System.out.println("----------⚠ FILE COULD NOT BE WRITTEN TO ⚠----------");
        }
    }
}