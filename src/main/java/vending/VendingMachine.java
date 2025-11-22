package vending;

import java.util.Map;
import vending.chain.SnackDispenseHandler;
import vending.state.IdleState;
import vending.state.State;
import vending.setup.SnackInventory;
import vending.setup.HandlerChainBuilder;

public class VendingMachine {
    private State _state;
    private Map<String, Snack> _snacks;
    private SnackDispenseHandler _handler;
    private String _selectedSnack;
    private double _insertedMoney;

    // Public constructor for dependency injection (used by factory and testing)
    public VendingMachine(Map<String, Snack> snacks, SnackDispenseHandler handler) {
        _snacks = snacks;
        _handler = handler;
        _selectedSnack = null;
        _insertedMoney = 0.0;
        _state = new IdleState(this);
    }

    // Public constructor maintains backward compatibility
    public VendingMachine() {
        this(SnackInventory.createDefaultInventory(), HandlerChainBuilder.buildDefaultChain());
    }

    public void selectSnack(String name) {
        _state.selectSnack(name);
    }

    public void insertMoney(double amount) {
        _state.insertMoney(amount);
    }

    public void dispense() {
        _state.dispense();
    }

    // Helpers for tests (package-private)
    State getState() {
        return _state;
    }

    public String getSelectedSnack() {
        return _selectedSnack;
    }

    public double getInsertedMoney() {
        return _insertedMoney;
    }

    public Map<String, Snack> getSnacks() {
        return _snacks;
    }

    SnackDispenseHandler getHandler() {
        return _handler;
    }

    // setters used by state implementations
    public void setState(State state) {
        this._state = state;
    }

    public void setSelectedSnack(String selectedSnack) {
        this._selectedSnack = selectedSnack;
    }

    public void setInsertedMoney(double amount) {
        this._insertedMoney = amount;
    }
}
