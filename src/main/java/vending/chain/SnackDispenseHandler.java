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
        throw new UnsupportedOperationException("stub");
    }

    protected DispenseResult forward(SnackRequest request, Map<String, Snack> snacks) {
        if (_next == null) {
            return new DispenseResult(false, request.getAmount(), "No handler", null);
        }
        return _next.handle(request, snacks);
    }
}
