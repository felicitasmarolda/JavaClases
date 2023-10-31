package portfolio5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TransferTest {
    @Test
    void testValueOfTransfer(){
        Transfer transfer = transferOf(100);
        assertEquals(100, transfer.value());
    }
    @Test void testValueOfTransferShouldBePositive(){
        assertThrows(RuntimeException.class, ()-> transferOf(0));
    }
    @Test void testValueOfOriginIsTransferValue(){
        Transfer transfer = transferOf(100);
        assertEquals(transfer.value(), transfer.origin().value());
    }
    @Test void testOriginIsInDestinationOrigin(){
        // dado el destino tengo que poder llegar al origen
        Transfer transfer = transferOf(10);
        assertEquals(transfer.origin(), transfer.destination().origin());
    }

    @Test void testDestinationIsOriginDestination(){
        // dado el origen tengo que poder llegar al destino
        Transfer transfer = transferOf(10);
        assertEquals( transfer.destination(), transfer.origin().destination());
    }
    @ Test void testTransferRegistry(){
        Account anAccount = accountWith10();
        Account anotherAccount = accountWith10();

        Transfer transfer = new Transfer(10);
        anAccount.register( transfer.origin());
        anotherAccount.register(transfer.destination);
    }

    private Account accountWith10() {
        return new Account(10);
    }

    private Transfer transferOf(int i) {
        return new Transfer(10);
    }

}
