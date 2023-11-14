package portfolio8;
public class SoloBalanceTreeReport extends ReportVisitor {
  private String prefix = "";
  
  public static String report( Accountable anAccount ) {
    SoloBalanceTreeReport report = new SoloBalanceTreeReport();
    return report.list( anAccount );
  }

  public void visitPortfolio( Portfolio target ) {
    report.add( prefix + "Portfolio: " + target.balance());

    String oldPrefix = prefix;
    prefix = prefix + "  ";
    target.visitAccountsOn( this );
    prefix = oldPrefix;
  }
  public void visitAccount( Account target ) {
    report.add( prefix + "Cuenta: " + target.balance());
  }
  public void visitDeposit( Deposit deposit ) {
  //  report.add( prefix + "  " + "Deposit: " + deposit.value() );
  }
  public void visitWithdraw( Withdraw withdraw ) {
    //report.add( prefix + "  " + "Withdraw: " + withdraw.value() );
  }

  public void visitTransferDestination( TransferDestination transferDestination ) {
    //report.add( prefix + "  " + "Depósito por transferencia de: " + transferDestination.value() );
  }

  public void visitTransferOrigin( TransferOrigin transferOrigin ) {
    //report.add( prefix + "  " + "Débito por transferencia de: " + transferOrigin.value() );
  }}
