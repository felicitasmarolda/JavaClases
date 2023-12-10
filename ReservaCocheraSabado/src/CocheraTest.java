import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

public class CocheraTest {
    Cochera cochera = new Cochera();
    Fecha octubre10de2020 = new Fecha(LocalDate.of(2020, 10, 10));
    Fecha diciembre13de2002 = new Fecha(LocalDate.of(2002, 12, 13));
    @Before
    public void setUp(){
        Cochera cochera = new Cochera();
        octubre10de2020 = new Fecha(LocalDate.of(2020, 10, 10));
        diciembre13de2002 = new Fecha(LocalDate.of(2002, 12, 13));
    }

    @Test
    public void test00NuevaCocheraHasNoReservations(){
        Cochera cochera = new Cochera();
    }

    @Test public void test01CocheraCanMakeReservationsForReasonMeeting(){
        closeDateWithMeeting(octubre10de2020, "Tyron");
        assertEquals("Tyron", cochera.getReservador(octubre10de2020));
    }

    @Test public void test02CocheraCanMakeReservationsForReasonClass(){
        closeDateWithClass(octubre10de2020,"Tasha");
        assertEquals("Tasha", cochera.getReservador(octubre10de2020));
    }

    @Test public void test03CocheraCanMakeReservationsForReasonPersonalUse(){
        closeWithPersonalUse(octubre10de2020, "Tyron");
        assertEquals("Tyron", cochera.getReservador(octubre10de2020));
    }

    @Test public void test04CocheraCanMakeReservationsInDifferentDates(){
        closeDateWithMeeting(octubre10de2020, "Uniqua");
        closeWithPersonalUse(diciembre13de2002, "Austin");
        assertEquals("Uniqua", cochera.getReservador(octubre10de2020));
        assertEquals("Austin", cochera.getReservador(diciembre13de2002));
    }
    @Test public void test05CocheraCanMakeReservationsForReasonMeetingInSameDateWithSameReason(){
        cochera.reservWithMeeting(diciembre13de2002, "Tasha");
        closeDateWithMeeting(diciembre13de2002, "Pablo");
        assertEquals("Tasha", cochera.getReservador(diciembre13de2002));
    }
    @Test public void test06CocheraCanMakeReservationsForReasonMeetingInSameDateWithDifferentReasonUseAndClass(){
        cochera.reservWithPersonalUse(octubre10de2020, "Uniqua");
        closeDateWithClass(octubre10de2020,"Tasha");
        assertEquals("Tasha", cochera.getReservador(octubre10de2020));
    }
    @Test public void test07CocheraCanMakeReservationsForReasonMeetingInSameDateWithDifferentReasonUseAndMeeting(){
        cochera.reservWithPersonalUse(octubre10de2020, "Pablo");
        closeDateWithMeeting(octubre10de2020, "Tyron");
        assertEquals("Tyron", cochera.getReservador(octubre10de2020));
    }
    @Test public void test08CocheraCanMakeReservationsForReasonMeetingInSameDateWithDifferentReason(){
        cochera.reservWithPersonalUse(octubre10de2020, "Tasha");
        closeDateWithClass(octubre10de2020,"Austin");
        assertEquals("Austin", cochera.getReservador(octubre10de2020));
    }
    @Test public void test09CocheraCanMakeReservationsForReasonMeetingInSameDateWithDifferentReason(){
        cochera.reservWithMeeting(octubre10de2020, "Uniqua");
        closeDateWithClass(octubre10de2020,"Pablo");
        assertEquals("Uniqua", cochera.getReservador(octubre10de2020));
    }

    @Test public void test10CocheraCanMakeReservationsOnMultipleDaysWithDifferentReasons(){
        closeDateWithMeeting(octubre10de2020, "Uniqua");
        cochera.reservWithClass(diciembre13de2002, "Pablo");
        closeWithPersonalUse(diciembre13de2002, "Tyron");
        assertEquals("Uniqua", cochera.getReservador(octubre10de2020));
        assertEquals("Pablo", cochera.getReservador(diciembre13de2002));
    }
    @Test public void test11CocheraCanNotCheckDateIfDateIsOpen(){
        cochera.reservWithMeeting(diciembre13de2002, "Uniqua");
        assertThrowsLike( () -> cochera.getReservador(diciembre13de2002), "No se puede consultar una fecha abierta");
    }
    @Test public void test12CocheraCanNotCheckDateWithNoReservations(){
        cochera.cerrarFecha(diciembre13de2002);
        assertThrowsLike( () -> cochera.getReservador(diciembre13de2002), "Fecha no reservada");
    }
    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }
    private void closeDateWithMeeting(Fecha fecha, String persona) {
        cochera.reservWithMeeting(fecha, persona);
        cochera.cerrarFecha(fecha);
    }

    private void closeDateWithClass(Fecha fecha, String persona) {
        cochera.reservWithClass(fecha, persona);
        cochera.cerrarFecha(fecha);
    }
    private void closeWithPersonalUse(Fecha octubre10de2020, String persona) {
        cochera.reservWithPersonalUse(octubre10de2020, persona);
        cochera.cerrarFecha(octubre10de2020);
    }

}
