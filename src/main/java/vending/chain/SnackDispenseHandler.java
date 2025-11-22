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
        if (!snackName.equalsIgnoreCase(request.getName())) {
            return forward(request, snacks);
        }

        Snack snack = snacks.get(snackName);
        if (snack == null) {
            return new DispenseResult(false, request.getAmount(), "Snack not found", null);
        }
        if (!snack.isAvailable()) {
            return new DispenseResult(false, request.getAmount(), "Out of stock", snack);
        }
        if (request.getAmount() < snack.getPrice()) {
            return new DispenseResult(false, request.getAmount(), "Insufficient funds", snack);
        }

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
