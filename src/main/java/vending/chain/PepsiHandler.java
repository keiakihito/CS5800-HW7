package vending.chain;

import java.util.Map;
import vending.Snack;

public class PepsiHandler extends SnackDispenseHandler {
    @Override
    public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
        return handleFor("Pepsi", request, snacks);
    }
}
