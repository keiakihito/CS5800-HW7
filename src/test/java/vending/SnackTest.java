package vending;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SnackTest {

    @Test
    void gettersReturnValues() {
        Snack snack = new Snack("Coke", 1.50, 3);

        assertEquals("Coke", snack.getName());
        assertEquals(1.50, snack.getPrice());
        assertEquals(3, snack.getQuantity());
    }

    @Test
    void isAvailableTrueWhenQuantityPositive() {
        Snack snack = new Snack("Pepsi", 1.25, 1);
        assertTrue(snack.isAvailable());
    }

    @Test
    void isAvailableFalseWhenQuantityZero() {
        Snack snack = new Snack("Pepsi", 1.25, 0);
        assertFalse(snack.isAvailable());
    }

    @Test
    void decrementStopsAtZero() {
        Snack snack = new Snack("Cheetos", 2.00, 1);

        snack.decrement();
        assertEquals(0, snack.getQuantity());
        snack.decrement(); // should not go negative
        assertEquals(0, snack.getQuantity());
    }
}
