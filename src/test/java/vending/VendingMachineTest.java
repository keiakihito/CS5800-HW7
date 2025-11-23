package vending;

import org.junit.jupiter.api.Test;
import vending.state.IdleState;
import vending.state.State;
import vending.state.WaitingForMoneyState;
import vending.state.DispensingState;
import vending.chain.DispenseResult;

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

    @Test
    void insertingEnoughMoneyMovesToDispensing() {
        VendingMachine machine = new VendingMachine();
        machine.selectSnack("Coke");

        machine.insertMoney(2.00);

        assertTrue(machine.getState() instanceof DispensingState, "Should move to Dispensing after enough money");
    }

    @Test
    void dispensingCallsChainAndResetsToIdle() {
        VendingMachine machine = new VendingMachine();
        machine.selectSnack("Coke");
        machine.insertMoney(2.00);

        machine.dispense();

        assertTrue(machine.getState() instanceof IdleState, "Should return to Idle after dispensing");
        assertEquals(0.0, machine.getInsertedMoney(), 0.0001, "Inserted money should reset after dispense");
        assertEquals("Coke", machine.getSelectedSnack(), "Selection stays for now or could be cleared in refactor");
        assertEquals(1, machine.getSnacks().get("Coke").getQuantity(), "Quantity should decrement by chain");
    }
}
