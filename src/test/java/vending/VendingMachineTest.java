package vending;

import org.junit.jupiter.api.Test;
import vending.state.IdleState;
import vending.state.State;
import vending.state.WaitingForMoneyState;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VendingMachineTest {
    @Test
    void startsInIdleState() {
        VendingMachine machine = new VendingMachine();

        assertTrue(machine.getState() instanceof IdleState, "machine should start in IdleState");
    }

    @Test
    void initializesSnackMapAndChain() {
        VendingMachine machine = new VendingMachine();

        assertNotNull(machine.getSnacks(), "snacks map should be initialized");
        assertNotNull(machine.getHandler(), "handler chain should be initialized");
    }

    @Test
    void selectingSnackFromIdleMovesToWaitingForMoney() {
        VendingMachine machine = new VendingMachine();

        machine.selectSnack("Coke");

        assertTrue(machine.getState() instanceof WaitingForMoneyState, "Should move to WaitingForMoney after selection");
        assertEquals("Coke", machine.getSelectedSnack());
    }
}
