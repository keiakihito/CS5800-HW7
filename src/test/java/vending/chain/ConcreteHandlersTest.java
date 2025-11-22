package vending.chain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vending.Snack;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConcreteHandlersTest {

    private SnackDispenseHandler chainHead;
    private Map<String, Snack> snacks;

    @BeforeEach
    void setUpChain() {
        chainHead = new CokeHandler();
        chainHead
                .setNext(new PepsiHandler())
                .setNext(new CheetosHandler())
                .setNext(new DoritosHandler())
                .setNext(new KitKatHandler())
                .setNext(new SnickersHandler());

        snacks = new HashMap<>();
        snacks.put("Coke", new Snack("Coke", 1.50, 2));
        snacks.put("Pepsi", new Snack("Pepsi", 1.50, 1));
        snacks.put("Cheetos", new Snack("Cheetos", 2.00, 2));
        snacks.put("Doritos", new Snack("Doritos", 2.00, 2));
        snacks.put("KitKat", new Snack("KitKat", 1.25, 2));
        snacks.put("Snickers", new Snack("Snickers", 1.75, 1));
    }

    @Test
    void chainDispensesMatchingSnackInOrder() {
        DispenseResult result = chainHead.handle(new SnackRequest("Pepsi", 2.00), snacks);

        assertTrue(result.isDispensed(), "Pepsi should be dispensed");
        assertEquals(0, snacks.get("Pepsi").getQuantity(), "Pepsi quantity should decrement");
        assertEquals(0.50, result.getChange(), 0.0001);
    }

    @Test
    void snickersOutOfStockReturnsChange() {
        snacks.put("Snickers", new Snack("Snickers", 1.75, 0)); // out of stock

        DispenseResult result = chainHead.handle(new SnackRequest("Snickers", 2.00), snacks);

        assertFalse(result.isDispensed(), "Should not dispense when out of stock");
        assertEquals(2.00, result.getChange(), 0.0001, "Should refund full amount");
    }
}
