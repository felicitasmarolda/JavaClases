package portfolio6b;

import java.util.ArrayList;
import java.util.List;


public class SummaryTreeReport {
  private List<String> report = new ArrayList();
  private String prefix = "";
  
  public static String report( Accountable anAccount ) {
    return new SummaryTreeReport().list( anAccount );
  }

  public String list( Accountable anAccount ) {
    anAccount.reportOn( this );

    return String.join("\n", report);
  }

  public void reportAsPortofolio( Portfolio portfolio ) {
    //portfolio.reportTransaction( this );
    report.add( prefix + portfolio.title() );

    portfolio.accounts.forEach( (accountable) -> {
        String oldPrefix = prefix;
        prefix = prefix + "  ";
        accountable.reportOn( this );
        prefix = oldPrefix;
    });
    report.add( prefix + portfolio.footer() );
   
  }

  public void reportAsAccount( Account anAccount ) {
    //anAccount.reportTrsansactionsOn( this );
    report.add( prefix + anAccount.title() );
    anAccount.transactions().forEach( (transaction) -> {
      report.add( prefix + "  " + transaction.reportDetail() );
    });
    report.add( prefix + anAccount.footer() );
  }

  public void reportAsTransaction( Transaction transaction){
    report.add( prefix + " " + transaction.reportDetail() );
  }
   
}
