package portfolio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account extends Accountable {
  private List<Transaction> transactions = new ArrayList();
  
  public int balance() {
    return transactions.stream()
        .map( (transaction) -> transaction.valueForBalance() )
        .reduce(0, (a, b) -> a + b);
  }

  public Account deposit( int anAmount ) {
    transactions.add( new Deposit( anAmount ) );
    return this;
  }

  public Account withdraw( int anAmount ) {
    if (balance() - anAmount < 0) {
      throw new RuntimeException( "not enough money in the account" );
    }
    
    transactions.add( new Withdraw( anAmount ) );
    return this;  }

  public String report(String prefix) {
    List<String> report = new ArrayList<String>();
        
    transactions.forEach( (transaction) -> {
      report.add( transaction.reportDetail() );
    });
    
    report.add( "Balance: " + balance() );
    
    return String.join("\n", report);
  }
  public boolean contains(Accountable anAccountable) {
    return equals(anAccountable) ;
  }
  public List<Account> accounts(){
    return Arrays.asList(this);
  }
  public void transfer(Account account, int anAmount) {
    // TODO Auto-generated method stub
    transactions.add( new TransferenciaEnvia(anAmount));
    account.recieveTransference(anAmount);

  }
  private void recieveTransference(int anAmount) {
    // TODO Auto-generated method stub
    transactions.add(new TransferenciaRecibe(anAmount));
  }
  public Account transferTo(int anAmount) {
    // TODO Auto-generated method stub
    if (balance() - anAmount < 0) {
      throw new RuntimeException( "not enough money in the account" );
    }

    transactions.add( new TransferenciaEnvia( anAmount ) );
    return this;
  }
  public Account recieveFrom(int anAmount) {
    // TODO Auto-generated method stub
    transactions.add( new TransferenciaRecibe( anAmount ) );
    return this;
  }
  public boolean equals(Accountable accountable) {
    return this == accountable;
  }

}
