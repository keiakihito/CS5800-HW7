package vending.state;

import vending.VendingMachine;

public class IdleState implements State {
    private final VendingMachine _machine;

    public IdleState(VendingMachine _machine) {
        this._machine = _machine;
    }

    @Override
    public void selectSnack(String name) {
        throw new UnsupportedOperationException("stub");
    }

    @Override
    public void insertMoney(double amount) {
        throw new UnsupportedOperationException("stub");
    }

    @Override
    public void dispense() {
        throw new UnsupportedOperationException("stub");
    }
}
