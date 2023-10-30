package portfolio4;

public abstract class Transaction {
  protected int value;

  public Transaction( int value ) {
    this.value = value;
  }
  
  public abstract int valueForBalance();
  public abstract String reportDetail();
  
  public int value() {
    return value;
  }
  
}

// nueva familia de transacciones que permitan hacer en cada cuenta por tranferencia
// tiene que ser compatible con lo que haciamos hasta ahora
//
