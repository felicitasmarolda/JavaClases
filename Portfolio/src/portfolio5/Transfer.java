package portfolio5;

public class Transfer {
    private int value;
    private TransferDeposit destination;
    private TransferWithdraw origin;

    public Transfer (int valueToTransfer){
        if (valueToTransfer <= 0) throw new RuntimeException();

        value = valueToTransfer;
        origin = new TransferWithdraw(valueToTransfer);
        destination = new TransferDeposit(valueToTransfer);
    }
    public int value(){return value;}

    public TransferWithdraw origin(){return origin;}

    public TransferDeposit destination(){return destination;}

}
