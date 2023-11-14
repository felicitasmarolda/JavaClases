package portfolio8;

import java.util.ArrayList;
import java.util.List;

public abstract class ReportVisitor implements PortfolioVisitor {

  protected List<String> report = new ArrayList();
  
  public String list( Accountable target ) {
    title();
    target.accept( this );
    footer();

    return String.join("\n", report);
  }

  public void title() {}
  public void footer() {}

  public void visitPortfolio( Portfolio target ){}
  public void visitAccount( Account target ){}
  public void visitDeposit( Deposit deposit ){}
  public void visitWithdraw( Withdraw withdraw ){}
  public void visitTransferDestination( TransferDestination transferDestination ){}
  public void visitTransferOrigin( TransferOrigin transferOrigin ){}
}
