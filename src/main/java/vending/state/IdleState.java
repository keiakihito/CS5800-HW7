package vending.state;

import vending.VendingMachine;

public class IdleState implements State {
    private final VendingMachine _machine;

    public IdleState(VendingMachine _machine) {
        this._machine = _machine;
    }

    @Override
    public void selectSnack(String name) {
        _machine.setSelectedSnack(name);
        _machine.setState(new WaitingForMoneyState(_machine));
    }

    @Override
    public void insertMoney(double amount) {
        // ignore; cannot insert money before selecting
    }

    @Override
    public void dispense() {
        // ignore; nothing to dispense
    }
}
