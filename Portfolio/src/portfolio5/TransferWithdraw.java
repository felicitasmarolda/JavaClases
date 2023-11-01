package portfolio5;

public class TransferWithdraw extends TransferTransaction {
    public TransferWithdraw( Transfer aTransfer ) {
        super(aTransfer);
    }
    public TransferDeposit destination(){
        return transfer.destination();
    }

    @Override
    public int valueForBalance() {
        return 0;
    }

    @Override
    public String reportDetail() {
        return null;
    }
}
