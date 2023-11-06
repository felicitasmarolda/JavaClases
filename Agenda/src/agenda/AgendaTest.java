package agenda;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.DayOfWeek;

class AgendaTest {

	private static LocalDate domingo25deJunio = LocalDate.of(2023, 6, 25);
	private static LocalDate jueves29deJunio = LocalDate.of(2023, 6, 29);
	private static LocalDate viernes30deJunio = LocalDate.of(2023, 6, 30);
	private static LocalDate sabado10deJunio = LocalDate.of(2023, 6, 10);

	@Test void test01agregaFeriado() {
		assertTrue( agendaWithRegisteredTodayHoliday().esFeriado( LocalDate.now() ) );
	}
	
	@Test void test02agregaFeriado() {
		assertTrue( agendaWithSundayHoliday().esFeriado( domingo25deJunio ));
	}
	
	@Test void test03agregaFeriadoRegisterStartDate() {
		assertTrue( agendaWithRegisteredPeriodHoliday().agregaFeriado(domingo25deJunio).esFeriado( domingo25deJunio ));
	}
	
	@Test void test04agregaFeriadoRegistersEndDate() {
		assertTrue( agendaWithRegisteredPeriodHoliday().agregaFeriado(viernes30deJunio).esFeriado( viernes30deJunio ));
	}
	
	@Test void test05agregaFeriadoRegisterDateInBetween() {
		assertTrue( agendaWithRegisteredPeriodHoliday().esFeriado( jueves29deJunio ));
	}
	
	@Test void test06esFeriadoReturnsFalseIfHolidayIsNotRegistered() {
		assertFalse( new Agenda().esFeriado( LocalDate.now() ));
	}
	
	@Test void test07esFeriadoReturnsFalseIfWrongDateIsAskedForSpecificHoliday() {
		assertFalse( new Agenda().agregaFeriado( domingo25deJunio ).esFeriado( jueves29deJunio ));
	}
	
	@Test void test08esFeriadoReturnsFalseIfWrongDateIsAskedForWeeklyHoliday() {
		assertFalse( agendaWithSundayHoliday().esFeriado( jueves29deJunio ) );
	}
	
	@Test void test09esFeriadoReturnsFalseIfWrongDateIsAskedForPeriodHoliday() {
		assertFalse( agendaWithRegisteredPeriodHoliday().esFeriado( sabado10deJunio ));
	}
	
	@Test void test10RegisteringAnExistentSpecificHolidayDoesNotThrowError() {
		assertTrue( agendaWithRegisteredTodayHoliday().agregaFeriado( LocalDate.now() ).esFeriado( LocalDate.now() ));
	}
	
	@Test void test11RegisteringAnExistentASpecificHolidayWeeklyHolidayDoesNotThrowError() {
		assertTrue( agendaWithSundayHoliday().agregaFeriado( domingo25deJunio ).esFeriado( domingo25deJunio ) );
	}
	
	@Test void test12RegisteringAnExistentWeeklyHolidayDoesNotThrowError() {
		assertTrue( agendaWithSundayHoliday().agregaFeriado( DayOfWeek.SUNDAY ).esFeriado( domingo25deJunio ) );
	}

	@Test void test13RegisteringAnExistentPeriodHolidayOnAWeeklyHolidayDoesNotThrowError() {
		assertTrue( agendaWithSundayHoliday().agregaFeriado( domingo25deJunio, viernes30deJunio).esFeriado( domingo25deJunio ) );
	}
	
	@Test void test14RegisteringAnExistentPeriodHolidayTwiceDoesNotThrowError() {
		assertTrue( agendaWithRegisteredPeriodHoliday().agregaFeriado( domingo25deJunio, viernes30deJunio).esFeriado( domingo25deJunio ) );
	}
	
	@Test void test15RegisteringASpecificHolidayOnAnExistentPeriodHolidayDoesNotThrowError() {
		assertTrue( agendaWithRegisteredPeriodHoliday().agregaFeriado( domingo25deJunio ).esFeriado( domingo25deJunio ) );
	}
	
	private Agenda agendaWithRegisteredTodayHoliday() {
		return new Agenda().agregaFeriado( LocalDate.now());
	}
	
	private Agenda agendaWithSundayHoliday() {
		return new Agenda().agregaFeriado( DayOfWeek.SUNDAY );
	}
	
	private Agenda agendaWithRegisteredPeriodHoliday() {
		return new Agenda().agregaFeriado( domingo25deJunio, viernes30deJunio);
	}		
}
