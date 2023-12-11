package reserva1;

public abstract class Reserva {
  public Reserva() {}
  public Reserva cerrar() {                 throw new Error();          } 
  public String consultar() {               throw new Error();          }
  public int prioridad() {                  return 0;                   }
  public Reserva mejorDe( Reserva turno ) { throw new Error();          }  
}

class ReservaNominada extends Reserva {
  private int prioridad;
  protected String nombre;
  public ReservaNominada( String aName, int prioridad ) {
    this.prioridad = prioridad;
    this.nombre = aName;
  }

  public Reserva cerrar() {                 return new ReservaCerrada( nombre );  }
  public int prioridad() {                  return prioridad;             }
  public Reserva mejorDe( Reserva nueva ) {
    if ( prioridad >= nueva.prioridad() ) {
      return this ;
    } else {
      return nueva;
    }
  }
}

class ReservaAbierta extends Reserva {
  public Reserva cerrar() {                 return new ReservaVacante();  }
  public Reserva mejorDe( Reserva nueva ) { return nueva;                 }
}

class ReservaVacante extends Reserva {}

class ReservaCerrada extends Reserva {
  protected String ganador;
  public ReservaCerrada( String aName ) {
    ganador = aName;
  }
  public String consultar() {               return ganador;               }
}