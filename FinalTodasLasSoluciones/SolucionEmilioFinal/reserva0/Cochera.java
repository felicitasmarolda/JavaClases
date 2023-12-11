package reserva0;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cochera {

  Map<LocalDate,Reserva> bookings = new HashMap();
  
  public void reservaPorReunion( String employee, LocalDate bookingDate ) {
    decidir( bookingDate, new Reserva( employee, 1 ) );
  }

  public void reservaPorClase( String employee, LocalDate bookingDate ) {
    decidir( bookingDate, new Reserva( employee, 2 ) );  }
  
  public void reservaPorPersonal( String employee, LocalDate bookingDate ) {
    decidir( bookingDate, new Reserva( employee, 3 ) );
  }

  private void decidir( LocalDate bookingDate, Reserva booking ) {
    if ( bookings.get( bookingDate ) != null &&
         !bookings.get( bookingDate ).abierto() ) throw new Error();
      
    if ( r.ganaA( bookings.get( bookingDate ) ) ) {
      bookings.put( bookingDate, booking );
    }
  }

  public void cerrar( LocalDate bookingDate ) {
    if ( bookings.get( bookingDate ) == null )
      bookings.put( bookingDate, new ReservaVacante(null, 0) );
    else
      bookings.get( bookingDate ).cerrar();
    
  }

  public Object consultar( LocalDate bookingDate ) {
    if ( bookings.get( bookingDate ) == null || bookings.get( bookingDate ).abierto() ) throw new Error();
      
    return bookings.get( bookingDate ).nombre();
  }

}
