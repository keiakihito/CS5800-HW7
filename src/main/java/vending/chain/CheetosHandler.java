package vending.chain;

import java.util.Map;
import vending.Snack;

public class CheetosHandler extends SnackDispenseHandler {
    @Override
    public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
        throw new UnsupportedOperationException("stub");
    }
}
