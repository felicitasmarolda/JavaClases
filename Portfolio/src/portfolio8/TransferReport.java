package portfolio8;

public class TransferReport extends ReportVisitor{

    private int ingresos = 0;
    private int egresos = 0;

    public void title(){
        report.add("Neto de Transferencias: ");
    }
    public void  footer(){
       if ( ingresos > 0) report.add("Entrada por transferencias: " + ingresos);
       if ( egresos > 0) report.add("Salida por transferencias: " + egresos);

    }
    @Override
    public void visitPortfolio(Portfolio target) {
        target.visitAccountsOn( this );
    }

    @Override
    public void visitAccount(Account target) {
        target.visitTransactionsOn( this);

    }

    @Override
    public void visitDeposit(Deposit deposit) {

    }

    @Override
    public void visitWithdraw(Withdraw withdraw) {

    }

    @Override
    public void visitTransferDestination(TransferDestination transferDestination) {
        ingresos = ingresos + transferDestination.value();

    }

    @Override
    public void visitTransferOrigin(TransferOrigin transferOrigin) {
        egresos = egresos + transferOrigin.value();

    }
}
