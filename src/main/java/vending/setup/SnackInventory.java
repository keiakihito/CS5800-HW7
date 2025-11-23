package vending.setup;

import java.util.HashMap;
import java.util.Map;
import vending.Snack;

public class SnackInventory {
    public static Map<String, Snack> createDefaultInventory() {
        // Central place to seed default snacks so tests/driver share the same data.
        Map<String, Snack> snacks = new HashMap<>();
        snacks.put("Coke", new Snack("Coke", 1.50, 2));
        snacks.put("Pepsi", new Snack("Pepsi", 1.50, 2));
        snacks.put("Cheetos", new Snack("Cheetos", 2.00, 2));
        snacks.put("Doritos", new Snack("Doritos", 2.00, 2));
        snacks.put("KitKat", new Snack("KitKat", 1.25, 2));
        snacks.put("Snickers", new Snack("Snickers", 1.75, 2));
        return snacks;
    }
}
