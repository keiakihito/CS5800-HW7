package vending.setup;

import java.util.Map;
import vending.VendingMachine;
import vending.chain.SnackDispenseHandler;

public class VendingMachineFactory {
    public static VendingMachine createDefault() {
        // Factory so the driver/tests can spin up a machine without repeating wiring code.
        Map<String, vending.Snack> snacks = SnackInventory.createDefaultInventory();
        SnackDispenseHandler handler = HandlerChainBuilder.buildDefaultChain();
        return new VendingMachine(snacks, handler);
    }
}
