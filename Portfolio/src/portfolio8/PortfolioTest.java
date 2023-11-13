package portfolio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
// import org.junit.jupiter.api.Test;

public class PortfolioTest {

  @Test
  public void testBalanceOnNewAccount() {
    assertEquals( 0, new Account().balance() );
  }

  @Test public void testBalanceAfterADeposit() {
    assertEquals( 10, accountWith10().balance() );
  }
  
  @Test public void testBalanceAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( 5, account.balance() );
  }

  @Test public void testWithdrawFailsIfNoResidue() {
    Account account = new Account();
    assertThrows( RuntimeException.class, () -> account.withdraw( 5 ) );
    assertEquals( 0, account.balance() );
  }
  
  // Portfolios
  @Test public void testBalanceOnNewPortfolio() {
    assertEquals( 0, new Portfolio().balance() );
  }

  @Test public void testBalanceAfterAddingAnAccount() {
    Portfolio p = new Portfolio();
    p.addAccount( accountWith10() );
    
    assertEquals( 10, p.balance() );
  }

  @Test public void testPortfolioFailsAfterAddingAnAccountTwice() {
    Portfolio p = new Portfolio();
    Account anAccount = accountWith10();
    p.addAccount( anAccount);
    
    assertThrows( RuntimeException.class, () -> p.addAccount( anAccount ) );

    assertEquals( 10, p.balance() );
  }


  @Test public void testPortfolioAfterAddingAPortfolio() {
    Portfolio a = new Portfolio();
    Portfolio b = new Portfolio();
    a.addAccount( b );
    
    assertEquals( 0, a.balance() );
  }

  @Test public void testPortfolioBalanceAddsWell() {
    Portfolio p = new Portfolio();
    p.addAccount( accountWith10() );
    p.addAccount( new Portfolio().addAccount( accountWith10() ) );

    assertEquals( 20, p.balance() );
  }

  // cuentas sin repetir
  @Test public  void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyAlone() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( a );
    
    assertThrows( RuntimeException.class, () -> b.addAccount( anAccount ) );

    assertEquals( 10, a.balance() );
  }

  @Test public void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInPortfolio() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( anAccount );
    
    assertThrows( RuntimeException.class, () -> b.addAccount( a ) );

    assertEquals( 10, a.balance() );
  }

  @Test public void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInOtherBranch() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( anAccount );
    
    assertThrows( RuntimeException.class, () -> new Portfolio().addAccount( a ).addAccount( b ) );

    assertEquals( 10, a.balance() );
  }
  
  private Account accountWith10() {
    return new Account().deposit( 10 );
  }


  
}
