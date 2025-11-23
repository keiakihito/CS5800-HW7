package vending.state;

import vending.VendingMachine;
import vending.chain.DispenseResult;
import vending.chain.SnackRequest;

public class DispensingState implements State {
    private final VendingMachine _machine;

    public DispensingState(VendingMachine _machine) {
        this._machine = _machine;
    }

    @Override
    public void selectSnack(String name) {
        throw new IllegalStateException("Cannot select snack while dispensing is in progress.");
    }

    @Override
    public void insertMoney(double amount) {
        throw new IllegalStateException("Cannot insert money while dispensing is in progress.");
    }

    @Override
    public void dispense() {
        SnackRequest request = createSnackRequest();
        processDispense(request);
        returnToIdle();
    }

    private SnackRequest createSnackRequest() {
        String selected = _machine.getSelectedSnack();
        double amount = _machine.getInsertedMoney();
        return new SnackRequest(selected, amount);
    }

    private void processDispense(SnackRequest request) {
        DispenseResult result = _machine.getHandler().handle(request, _machine.getSnacks());
        _machine.setLastDispenseResult(result);
    }

    private void returnToIdle() {
        _machine.setInsertedMoney(0.0);
        _machine.setState(new IdleState(_machine));
    }
}
