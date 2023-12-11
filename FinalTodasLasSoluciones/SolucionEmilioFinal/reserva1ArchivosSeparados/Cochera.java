package reserva1ArchivosSeparados;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cochera {

  Map<LocalDate, Reserva> bookings = new HashMap();
  
  public void reservaPorReunion( String employee, LocalDate bookingDate ) {
    decidir( bookingDate, new ReservaNominada( employee, 3 ) );
  }
  public void reservaPorClase( String employee, LocalDate bookingDate ) {
    decidir( bookingDate, new ReservaNominada( employee, 2 ) );  }
  
  public void reservaPorPersonal( String employee, LocalDate bookingDate ) {
    decidir( bookingDate, new ReservaNominada( employee, 1 ) );
  }

  private void decidir( LocalDate bookingDate, Reserva booking ) {
    bookings.put( bookingDate, reservaEn( bookingDate ).mejorDe( booking ) );
  }

  public void cerrar( LocalDate bookingDate ) {
    bookings.put( bookingDate, reservaEn( bookingDate ).cerrar() );
  }

  public String consultar( LocalDate bookingDate ) {
    return reservaEn( bookingDate ).consultar();
  }

  private Reserva reservaEn(LocalDate bookingDate ) {
    return bookings.getOrDefault( bookingDate, new ReservaAbierta() );
  }

}
