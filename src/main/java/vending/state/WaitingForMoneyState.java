package vending.state;

import vending.VendingMachine;
import vending.Snack;

public class WaitingForMoneyState implements State {
    private final VendingMachine _machine;

    public WaitingForMoneyState(VendingMachine _machine) {
        this._machine = _machine;
    }

    @Override
    public void selectSnack(String name) {
        throw new IllegalStateException("Snack already selected. Cannot select another snack while waiting for money.");
    }

    @Override
    public void insertMoney(double amount) {
        double newAmount = addMoney(amount);
        if (isReadyToDispense(newAmount)) {
            transitionToDispensing(); // move forward only when funds meet or exceed the price
        }
    }

    private double addMoney(double amount) {
        double newAmount = _machine.getInsertedMoney() + amount;
        _machine.setInsertedMoney(newAmount);
        return newAmount;
    }

    private boolean isReadyToDispense(double totalAmount) {
        Snack selected = getSelectedSnack();
        if (selected == null) {
            return false;
        }
        return hasSufficientFunds(totalAmount, selected);
    }

    private boolean hasSufficientFunds(double totalAmount, Snack snack) {
        return totalAmount >= snack.getPrice();
    }

    private Snack getSelectedSnack() {
        String snackName = _machine.getSelectedSnack();
        return _machine.getSnacks().get(snackName);
    }

    private void transitionToDispensing() {
        _machine.setState(new DispensingState(_machine));
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Cannot dispense until sufficient money is inserted.");
    }
}
