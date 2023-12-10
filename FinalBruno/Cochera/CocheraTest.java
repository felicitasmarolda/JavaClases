package Cochera;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class CocheraTest {

    private static LocalDate domingo25deJunio = LocalDate.of(2023, 6, 25);
	private static LocalDate jueves29deJunio = LocalDate.of(2023, 6, 29);
    private static String CarPlateABC = "ABC123";
    private static String CarPlateCBA = "CBA321";
    private static String CarPlateCDE = "CDE321";
    private Cochera cochera;
    
    @BeforeEach public void setUp() {
        cochera =  new Cochera();
    }

    @Test public void testParkInOpenDay (){
        cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkFirstMeetingCarThanClassCar (){
        cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC).addClassCarFor(domingo25deJunio, CarPlateCBA);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkFirstMeetingCarThanPersonlCar (){
        cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC).addPersonalCarFor(domingo25deJunio, CarPlateCBA);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkFirstMeetingCarThanClassCarAndPersonalCar (){
        cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC).addClassCarFor(domingo25deJunio, CarPlateCBA).addPersonalCarFor(domingo25deJunio, CarPlateCDE);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkFirstClassCarThanMeetingCar (){
        cochera.addClassCarFor(domingo25deJunio, CarPlateCBA).addPersonalCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateCBA);
    }


    @Test public void testParkfirstMeetingCarEvenIfItCameLater (){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateCBA).addMeetingCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkfirstMeetingCarEvenIfItCameLaterThanCarClass (){
        cochera.addClassCarFor(domingo25deJunio, CarPlateCBA).addMeetingCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkfirstMeetingCarEvenIfItCameLaterThanCarClassAndPersonalCar (){
        cochera.addClassCarFor(domingo25deJunio, CarPlateCBA).addPersonalCarFor(domingo25deJunio, CarPlateCDE).addMeetingCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testParkfirstClassCarThanPersonalCarEvenIfItCameLater(){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateABC).addClassCarFor(domingo25deJunio, CarPlateCBA);
        assertClosedDay(domingo25deJunio, CarPlateCBA);
    }

    @Test public void testForTwoCarsSamePriorityParksWhoCameFirstMeetingCar (){
        cochera.addClassCarFor(domingo25deJunio, CarPlateCDE).addMeetingCarFor(domingo25deJunio, CarPlateABC).addMeetingCarFor(domingo25deJunio, CarPlateCBA);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

     @Test public void testForTwoCarsSamePriorityParksWhoCameFirsClassCar (){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateCBA).addClassCarFor(domingo25deJunio, CarPlateCDE).addClassCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateCDE);
    }
    @Test public void testForTwoCarsSamePriorityParksWhoCameFirstPersonalCar (){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateABC).addPersonalCarFor(domingo25deJunio, CarPlateCBA);
        assertClosedDay(domingo25deJunio, CarPlateABC);
    }

    @Test public void testYouCanReserveDifferentdaysAtThesameTime (){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateABC).addPersonalCarFor(jueves29deJunio, CarPlateCBA).addPersonalCarFor(domingo25deJunio, CarPlateCDE);
        assertClosedDay(domingo25deJunio, CarPlateABC);
        assertClosedDay(jueves29deJunio, CarPlateCBA);
    }
    
    @Test public void testYouCanCloseADayEvenIfThereIsNoCarParked (){
        cochera.closeDay(domingo25deJunio);
        assertFalse(cochera.isOpen(domingo25deJunio));
    }

    @Test public void testYouCanConsultIfTheresIsNoCarParked(){
        cochera.closeDay(domingo25deJunio);
        assertThrowsLike( () -> cochera.carParkedOn(domingo25deJunio), Cochera.dayClosedWithNoCarErroMessage);
    }
    
    @Test public void testParkInClosedDay (){
        cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateABC);
        assertThrowsLike( () -> cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC), Cochera.CannotParkInClosedDayErrorMessage);
    }
    
    @Test public void testYouCannotGetParkedCarIfDayIsStillOpen (){
        cochera.addMeetingCarFor(domingo25deJunio, CarPlateABC);
        assertThrowsLike( () -> cochera.carParkedOn(domingo25deJunio), Cochera.DayStillOpenErrorMessage);
    }


    @Test public void testYouCanReserveTwoTimesTheSameDay (){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateABC).addPersonalCarFor(domingo25deJunio, CarPlateABC);
        assertClosedDay(domingo25deJunio, CarPlateABC);	
            
    }

    @Test public void testReserveTwoTimesDoesntAffectPriority(){
        cochera.addPersonalCarFor(domingo25deJunio, CarPlateABC).addPersonalCarFor(domingo25deJunio, CarPlateCBA).addMeetingCarFor(domingo25deJunio, CarPlateCDE);
        assertClosedDay(domingo25deJunio, CarPlateCDE);	
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }
    
    private void assertClosedDay(LocalDate day , String plate) {
        cochera.closeDay(day);
        assertFalse(cochera.isOpen(day));
        assertEquals(cochera.carParkedOn(day), plate);
    }



}
