package vending.chain;

import java.util.Map;
import vending.Snack;

public class SnickersHandler extends SnackDispenseHandler {
    @Override
    public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
        return handleFor("Snickers", request, snacks);
    }
}
