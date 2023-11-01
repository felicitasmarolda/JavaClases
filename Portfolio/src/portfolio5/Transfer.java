package portfolio5;

public class Transfer {
    private int value;
    private TransferDeposit destination;
    private TransferWithdraw origin;

    public static Transfer register( int anAmmount, Account originAccount, Account destinationAccount){
        Transfer transfer = new Transfer(anAmmount);
        originAccount.register(transfer.origin());
        destinationAccount.register( transfer.destination );
        return transfer;
    }

    public Transfer (int anAmmount){
        if (anAmmount <= 0) throw new RuntimeException();

        value = anAmmount;
        origin = new TransferWithdraw(this);
        destination = new TransferDeposit(this);
    }
    public int value(){return value;}

    public TransferWithdraw origin(){return origin;}

    public TransferDeposit destination(){return destination;}

}
