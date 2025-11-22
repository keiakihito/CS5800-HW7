package vending.chain;

import org.junit.jupiter.api.Test;
import vending.Snack;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SnackDispenseHandlerTest {

    @Test
    void handleReturnsNoHandlerWhenUnlinked() {
        PassThroughHandler head = new PassThroughHandler();
        Map<String, Snack> snacks = new HashMap<>();
        DispenseResult result = head.handle(new SnackRequest("Coke", 1.0), snacks);

        assertFalse(result.isDispensed());
        assertEquals(1.0, result.getChange());
        assertEquals("No handler", result.getMessage());
    }

    @Test
    void handlePassesToNextHandler() {
        PassThroughHandler head = new PassThroughHandler();
        FakeHandler next = new FakeHandler();
        head.setNext(next);

        Map<String, Snack> snacks = new HashMap<>();
        DispenseResult result = head.handle(new SnackRequest("Coke", 1.0), snacks);

        assertTrue(next.wasCalled);
        assertTrue(result.isDispensed());
        assertEquals(0.0, result.getChange());
    }

    // Helper classes for testing
    private static class PassThroughHandler extends SnackDispenseHandler {
        @Override
        public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
            return super.handle(request, snacks);
        }
    }

    private static class FakeHandler extends SnackDispenseHandler {
        boolean wasCalled = false;

        @Override
        public DispenseResult handle(SnackRequest request, Map<String, Snack> snacks) {
            wasCalled = true;
            return new DispenseResult(true, 0.0, "handled", null);
        }
    }
}
