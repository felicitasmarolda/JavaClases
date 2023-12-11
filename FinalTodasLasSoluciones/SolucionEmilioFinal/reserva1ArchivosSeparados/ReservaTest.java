package reserva1ArchivosSeparados;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*Reserva de Cochera

Una empresa quiere mejorar la distribucion de uso de la unica cochera que tienen entre sus empleados. 
Para eso nos piden hacer un programa para que decida quien debe usar la cochera en base a los pedidos de uso que hubo de ella.
El sistema debe permitir recibir pedidos de reserva a una fecha, una persona, y con algun motivo.

Los motivos pueden ser: 1) Tengo reunion con cliente 2) Tengo que dar una clase 3) Uso personal.
cuando se cierra la reserva para un dia ya no se pueden hacer mas reservas. 
Esto significa que no se recibiran mas pedidos para esa fecha.
Solo cuando se cerro una fecha se puede consultar el nombre asignado. 
Si se cierra una fecha sin postulantes, no se podra consultar esa fecha.
La asignacion de la cochera se hace de la siguiente forma:
1) si hay un solo pedido, se le otorga a esa persona
2) si hay mas de uno, se prioriza por motivo. Tiene prioridad la reunion con el cliente, luego dar clase y por ultimo el uso personal.
3) a una misma prioridad, tien prefernecia el pedido anterior.
 */

public class ReservaTest {

  LocalDate today = LocalDate.of( 2023, 6, 15 );
  LocalDate tomorrow = LocalDate.of( 2023, 6, 16 );
  
  @Test void testReservoUnaFechaPorReunion() {
    Cochera cochera = new Cochera();
    cochera.reservaPorReunion( "Bob", today);
    cochera.cerrar( today);

    assertEquals( "Bob", cochera.consultar( today) );
  }

  @Test void testReservoUnaFechaPorClase() {
    Cochera cochera = new Cochera();
    cochera.reservaPorClase( "Bob", today);
    cochera.cerrar( today);
    assertEquals( "Bob", cochera.consultar( today) );
  }
  
  @Test void testReservoUnaFechaPorPersonal() {
    Cochera cochera = new Cochera();
    cochera.reservaPorPersonal( "Bob", today);
    cochera.cerrar( today);
    assertEquals( "Bob", cochera.consultar( today) );
  }  

  @Test void testReservoUnaFechaPorReunionYPersonal() {
    Cochera cochera = new Cochera();
    cochera.reservaPorReunion( "Bob", today);
    cochera.reservaPorPersonal( "Kevin", today);
    cochera.cerrar( today);
    assertEquals( "Bob", cochera.consultar( today) );
  }  
  
  @Test void testReservoUnaFechaPorPersonalYReunion() {
    Cochera cochera = new Cochera();
    cochera.reservaPorPersonal( "Kevin", today);
    cochera.reservaPorReunion( "Bob", today);
    cochera.cerrar( today);
    assertEquals( "Bob", cochera.consultar( today) );
  }      

  @Test void testReservoUnaFechaPorReunionYReunion() {
    Cochera cochera = new Cochera();
    cochera.reservaPorReunion( "Kevin", today);
    cochera.reservaPorReunion( "Bob", today);
    cochera.cerrar( today);
    assertEquals( "Kevin", cochera.consultar( today) );
  }      

  @Test void testReservoDosFechasPorPersonalYReunion() {
    Cochera cochera = new Cochera();
    cochera.reservaPorPersonal( "Kevin", today);
    cochera.reservaPorReunion( "Bob", tomorrow );
    cochera.cerrar( today);
    assertEquals( "Kevin", cochera.consultar( today) );
    cochera.cerrar( LocalDate.of( 2023, 6, 16 ) );
    assertEquals( "Bob", cochera.consultar( tomorrow ) );
  } 
  
 
  @Test void testReservoUnaFechaPorPersonalConsultoSincerrar() {
    Cochera cochera = new Cochera();
    cochera.reservaPorReunion( "Bob", today);
    assertThrows( Error.class, () -> cochera.consultar( today) );
  }      

  @Test void testcierroSinReservar() {
    Cochera cochera = new Cochera();
    cochera.cerrar( today );
    assertThrows( Error.class, () -> cochera.consultar( today ) );
  }      

  @Test void testConsultoSinReservar() {
    assertThrows( Error.class, () -> new Cochera().consultar( today ) );
  }      
  
  @Test void testConsultoSinCerrar() {
    Cochera cochera = new Cochera();
    cochera.reservaPorReunion( "Bob", today);
    assertThrows( Error.class, () -> cochera.consultar( today ) );
  }      
    
  @Test void testReservoDespuesDeCerrar() {
    Cochera cochera = new Cochera();
    cochera.cerrar( today );
    assertThrows( Error.class, () -> cochera.reservaPorReunion( "Bob", today ) );
  }      

}

