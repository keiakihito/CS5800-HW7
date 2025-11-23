package vending.chain;

import java.util.Map;
import vending.Snack;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler _next;

    public SnackDispenseHandler setNext(SnackDispenseHandler handler) {
        this._next = handler;
        return handler;
    }

    public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
        return forward(request, snacks);
    }

    protected DispenseResult handleFor(String snackName, SnackRequest request, Map<String, Snack> snacks) {
        // Concrete handlers call this: if name matches, try to dispense, otherwise pass down the chain.
        if (!isMatchingSnack(snackName, request)) {
            return forward(request, snacks);
        }

        Snack snack = snacks.get(snackName);
        DispenseResult validationResult = validateSnackDispense(snack, request);
        if (validationResult != null) {
            return validationResult;
        }

        return dispenseSnack(snack, snackName, request);
    }

    private boolean isMatchingSnack(String snackName, SnackRequest request) {
        return snackName.equalsIgnoreCase(request.getName());
    }

    private DispenseResult validateSnackDispense(Snack snack, SnackRequest request) {
        if (snack == null) {
            return new DispenseResult(false, request.getAmount(), "Snack not found", null);
        }
        if (!snack.isAvailable()) {
            return new DispenseResult(false, request.getAmount(), "Out of stock", snack);
        }
        if (request.getAmount() < snack.getPrice()) {
            return new DispenseResult(false, request.getAmount(), "Insufficient funds", snack);
        }
        return null; // Validation passed
    }

    private DispenseResult dispenseSnack(Snack snack, String snackName, SnackRequest request) {
        snack.decrement();
        double change = request.getAmount() - snack.getPrice();
        return new DispenseResult(true, change, "Dispensed " + snackName, snack);
    }

    protected DispenseResult forward(SnackRequest request, Map<String, Snack> snacks) {
        if (_next == null) {
            return new DispenseResult(false, request.getAmount(), "No handler", null);
        }
        return _next.handle(request, snacks);
    }
}
