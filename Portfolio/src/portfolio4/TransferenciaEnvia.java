package portfolio4;

public class TransferenciaEnvia extends Transaction{
    public TransferenciaEnvia( int value ) {
        super( value );
    }

    public int valueForBalance() {
        return value * -1;
    }

    public String reportDetail() {
        return "Retiro por transferencia: " + value;
    }
}
