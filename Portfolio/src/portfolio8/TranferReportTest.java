package portfolio8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranferReportTest {

  @Test public void testReportAfterADeposit() {
    assertEquals( "Neto de Transferencias: ", SoloBalanceTreeReport.report( accountWith10() ) );
  }
  
  @Test public void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Cuenta: 5", SoloBalanceTreeReport.report( account ) );
  }

  @Test public void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +
                  "  Portfolio:\n" +
                  "    Cuenta:\n" +
                  "  Cuenta:\n" +
                  "  Portfolio:\n" +
                  "    Cuenta:\n",
                  SummaryTreeReport.report(
                      new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                                     .addAccount( accountWith10() )
                                     .addAccount( new Portfolio().addAccount( accountWith10() ) ) ) );
  }

  @Test public void testReportAfterATransferenceWithdraw() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();

    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Neto de Transferencias: \n" +
                  "  Salida por transferencias: 10", TransferReport.report( anAccount ) );
  }

  // reportes:
  @Test public void testReportPortfolioAfterADeposit() {
    assertEquals("Neto de Transferencias:\n" +
                    "  Entrada por Transferenias: 10",
            SoloBalanceTreeReport.report( new Portfolio().addAccount( accountWith10() ) ) );
  }

  @Test public void testReportAfterATransferenceDeposit() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();

    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" +
                  "  Deposit: 10\n" +
                  "  Depósito por transferencia de: 10", SummaryTreeReport.report( anotherAccount ) );
  }

  private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
    return Transfer.register( anAmmount, originAccount, destinationAccount );
  }

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }

}
