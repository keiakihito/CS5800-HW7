package vending.chain;

import java.util.Map;
import vending.Snack;

public class DoritosHandler extends SnackDispenseHandler {
    @Override
    public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
        throw new UnsupportedOperationException("stub");
    }
}
