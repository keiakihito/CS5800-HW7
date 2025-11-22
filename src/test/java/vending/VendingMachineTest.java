package vending;

import org.junit.jupiter.api.Test;
import vending.state.IdleState;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VendingMachineTest {
    @Test
    void startsInIdleState() {
        VendingMachine machine = new VendingMachine();

        assertTrue(machine.getState() instanceof IdleState, "machine should start in IdleState");
    }
}
