package vending.chain;

import vending.Snack;

public class DispenseResult {
    private final boolean _dispensed;
    private final double _change;
    private final String _message;
    private final Snack _snack;

    public DispenseResult(boolean dispensed, double change, String message, Snack snack) {
        this._dispensed = dispensed;
        this._change = change;
        this._message = message;
        this._snack = snack;
    }

    public boolean isDispensed() {
        return _dispensed;
    }

    public double getChange() {
        return _change;
    }

    public String getMessage() {
        return _message;
    }

    public Snack getSnack() {
        return _snack;
    }
}
