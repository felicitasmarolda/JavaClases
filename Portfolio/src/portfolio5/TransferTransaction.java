package portfolio5;

public class TransferTransaction extends Transaction{
    private Transfer transfer;

    public TransferTransaction(Transfer aTransfer) {
        super(aTransfer.value());
        transfer = aTransfer;
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
