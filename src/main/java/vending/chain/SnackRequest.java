package vending.chain;

public class SnackRequest {
    private final String _name;
    private final double _amount;

    public SnackRequest(String name, double amount) {
        this._name = name;
        this._amount = amount;
    }

    public String getName() {
        return _name;
    }

    public double getAmount() {
        return _amount;
    }
}
