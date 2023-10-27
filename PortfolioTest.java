package portfolio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

  @Test void testBalanceOnNewAccount() {
    assertEquals( 0, new Account().balance() );
  }

  @Test void testBalanceAfterADeposit() {
    assertEquals( 10, new Account().deposit( 10 ).balance() );
  }
  
  @Test void testBalanceAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( 5, account.balance() );
  }

  @Test void testWithdrawFailsIfNoResidue() {
    Account account = new Account();
    assertThrows( RuntimeException.class, () -> account.withdraw( 5 ) );
    assertEquals( 0, account.balance() );
  }
  

  @Test void testReportAfterADeposit() {
    assertEquals( "Deposit: 10\n" +
                  "Balance: 10",
                  new Account().deposit( 10 ).report() );
  }
  
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Deposit: 10\n" +
                  "Withdraw: 5\n" +
                  "Balance: 5", account.report() );
  }
  // Portfolio
  @Test void balanceOfNewPortfolioIsZero() {
    assertEquals(0, new Portfolio().balance());
  }

  @Test void balanceAfterAddingAnAccount() {
    Portfolio portfolio = new Portfolio();
    portfolio.add( new Account().deposit( 10) );
    assertEquals(10, portfolio.balance());
  }

  @Test void balanceAfterAddingAnAccountTwiceShouldFail(){
    Portfolio portfolio = new Portfolio();
    Account account = new Account().deposit(10);

    portfolio.add( account );
    assertThrows( Exception.class, () -> portfolio.add( account ));
  }

  @Test void testBalanceAfterAddingAPortfolio(){
    Portfolio portfolio = new Portfolio();
    portfolio.add( new Account().deposit( 10) );

    Portfolio otroPortfolio = new Portfolio();
    otroPortfolio.add (portfolio);

    assertEquals(10, otroPortfolio.balance());
  }

  // test de no poder agragar un portfolio que tiene un account que ya esta en otro
}
