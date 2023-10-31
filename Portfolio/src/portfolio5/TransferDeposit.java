package portfolio5;

public class TransferDeposit extends TranferTransaction {

    public TransferDeposit(Transfer aTransfer) {
        super( aTransfer );
    }

    @Override
    public int valueForBalance() {
        return 0;
    }

    @Override
    public String reportDetail() {
        return null;
    }

    public Transaction origin(){
        return transfer.origin();
    }
}
