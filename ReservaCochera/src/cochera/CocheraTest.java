package cochera;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CocheraTest {

    @Test
    public void test00NewCocheraHasNoReservations(){
        Cochera cochera = new Cochera();
        assertEquals(0, cochera.reservas.size());
    }

    @Test public void test01CanReserveCocheraWithMotivoType1(){
        Cochera cochera = new Cochera();
        Fecha fecha = new Fecha(LocalDate.of(2019, 10, 10));
        cochera.reservarAsMeeting(fecha, "Pedrito");
        cochera.cerrarFecha(fecha);
        assertEquals(1, cochera.reservas.size());
  //      assertEquals("Pedrito", cochera.getQuienFueAsignado(fecha));
    }

    @Test public void test02CanReserveCocheraWithMotivoType2(){
        Cochera cochera = new Cochera();
        Fecha fecha = new Fecha(LocalDate.of(2019, 10, 10));
        cochera.reservarAsClass(fecha, "Pedrito");
        cochera.cerrarFecha(fecha);
        assertEquals("Pedrito", cochera.getQuienFueAsignado(fecha));
    }
    @Test public void test03CanReserveCocheraWithMotivoType3(){
        Cochera cochera = new Cochera();
        Fecha fecha = new Fecha(LocalDate.of(2019, 10, 10));
        cochera.reservarAsPersonalUse(fecha, "Pedrito");
        cochera.cerrarFecha(fecha);
        assertEquals("Pedrito", cochera.getQuienFueAsignado(fecha));
    }

    @Test public void test04CanReserveCocheraWithMotivoType1AndType2OnDifferentDates(){
        Cochera cochera = new Cochera();
        Fecha fecha1 = new Fecha(LocalDate.of(2019, 10, 10));
        Fecha fecha2 = new Fecha(LocalDate.of(2019, 9, 11));
        cochera.reservarAsMeeting(fecha1, "Pedrito");
        cochera.reservarAsClass(fecha2, "Juanita");
        cochera.cerrarFecha(fecha1);
        cochera.cerrarFecha(fecha2);
        assertEquals("Pedrito", cochera.getQuienFueAsignado(fecha1));
        assertEquals("Juanita", cochera.getQuienFueAsignado(fecha2));
    }


}
