package reserva0;

public class Reserva {
  private int prioridad;
  private String nombre;
  private boolean cerrada = false;

  public Reserva( String aName, int prioridad ) {
    this.prioridad = prioridad;
    this.nombre = aName;
  }

  public String nombre() {
    return nombre;
  }

  public boolean ganaA( Reserva turno ) {
    if (turno == null)
      return true;
    else if (prioridad < turno.prioridad ) 
      return true;
    else 
      return false;
  }

  public void cerrar() {
    cerrada = true;
  }

  public boolean abierto() {
    return !cerrada;
  }
}

class ReservaVacante extends Reserva {
  public ReservaVacante( String aName, int prioridad ) {
    super( aName, prioridad );
  }

  public String nombre() {
    throw new Error();
  }
  public boolean abierto() {
    return false;
  }
}