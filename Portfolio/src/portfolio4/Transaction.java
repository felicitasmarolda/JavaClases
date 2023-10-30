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
// Necesitamos deinir Transferencias, en donde movemmos dinero de un origen a un destino
// El modelo resultante debe ser compatible con lo desarrolado hasta ahora, es decir,
// permitir un balance y nu reporte
// pero ademas debe poder lllegarse desde una pata de la transferencia a la otra