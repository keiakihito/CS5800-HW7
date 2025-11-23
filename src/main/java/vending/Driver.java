package vending;

import vending.setup.VendingMachineFactory;

public class Driver {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachineFactory.createDefault();

        System.out.println("=== Vending Machine Demo (State + Chain of Responsibility) ===");
        System.out.println();
        System.out.println("Selecting Coke");
        machine.selectSnack("Coke");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Coke: " + machine.getSnacks().get("Coke").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting Pepsi");
        machine.selectSnack("Pepsi");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Pepsi: " + machine.getSnacks().get("Pepsi").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting Cheetos");
        machine.selectSnack("Cheetos");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Cheetos: " + machine.getSnacks().get("Cheetos").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting Doritos");
        machine.selectSnack("Doritos");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Doritos: " + machine.getSnacks().get("Doritos").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting KitKat");
        machine.selectSnack("KitKat");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for KitKat: " + machine.getSnacks().get("KitKat").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting Snickers");
        machine.selectSnack("Snickers");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Snickers: " + machine.getSnacks().get("Snickers").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting Snickers (should deplete to 0)");
        machine.selectSnack("Snickers");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Snickers: " + machine.getSnacks().get("Snickers").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());

        System.out.println();
        System.out.println("Selecting Snickers (expected to be out of stock)");
        machine.selectSnack("Snickers");
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        System.out.printf("Inserting $%.2f%n", 2.00);
        machine.insertMoney(2.00);
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
        machine.dispense();
        System.out.println("Result: " + machine.getLastDispenseResult().getMessage());
        System.out.printf("Change: $%.2f%n", machine.getLastDispenseResult().getChange());
        System.out.println("Quantity left for Snickers: " + machine.getSnacks().get("Snickers").getQuantity());
        System.out.println("State: " + machine.getState().getClass().getSimpleName());
    }
}
