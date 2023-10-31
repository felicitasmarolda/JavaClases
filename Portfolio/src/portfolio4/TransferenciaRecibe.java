package portfolio4;

public class TransferenciaRecibe extends Transaction{
    public TransferenciaRecibe(int value) {
        super( value );
    }

    public int valueForBalance() {
        return value;
    }

    public String reportDetail() {
        return "Deposit: " + value;
    }
}
