package vending.chain;

import java.util.Map;
import vending.Snack;

public class CokeHandler extends SnackDispenseHandler {
    @Override
    public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
        return handleFor("Coke", request, snacks);
    }
}
