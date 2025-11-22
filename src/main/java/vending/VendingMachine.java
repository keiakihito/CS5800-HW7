package vending;

import java.util.Map;

import vending.chain.SnackDispenseHandler;
import vending.state.State;

public class VendingMachine {
    private State _state;
    private Map<String, Snack> _snacks;
    private SnackDispenseHandler _handler;
    private String _selectedSnack;
    private double _insertedMoney;

    public void selectSnack(String name) {
        throw new UnsupportedOperationException("stub");
    }

    public void insertMoney(double amount) {
        throw new UnsupportedOperationException("stub");
    }

    public void dispense() {
        throw new UnsupportedOperationException("stub");
    }

    // Helpers for tests (package-private)
    State getState() {
        return _state;
    }

    String getSelectedSnack() {
        return _selectedSnack;
    }

    double getInsertedMoney() {
        return _insertedMoney;
    }

    Map<String, Snack> getSnacks() {
        return _snacks;
    }

    SnackDispenseHandler getHandler() {
        return _handler;
    }
}
