package Agenda;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class AgendaTest {
    LocalDate date1 = LocalDate.of(2019, 12, 25);
    LocalDate date2 = LocalDate.of(2019, 12, 28);
    LocalDate date3 = LocalDate.of(2019, 12, 26);
    DayOfWeek sunday = DayOfWeek.SUNDAY;
    Agenda agenda = new Agenda();
    @Before public void setUp(){
        Agenda agenda = new Agenda();
        date1 = LocalDate.of(2019, 12, 25);
        date2 = LocalDate.of(2019, 12, 26);
        sunday = DayOfWeek.SUNDAY;
    }
    @Test public void test01AddSpecificHoliday(){
        assertAfterAddingSpecificHoliday();
    }

    @Test public void test02AddWeeklyHoliday(){
        assertAfterAddingWeeklyHoliday();
    }

    @Test public void test03AddPeriodHolidayRegisterBegging(){
        assertAfterAddingPeriodHolidayAt(date1);
    }

    @Test public void test04AddPeriodHolidayRegisterEnd(){
        assertAfterAddingPeriodHolidayAt(date2);
    }
    @Test
    public void test05AddPeriodHolidayRegisterMiddle(){
        assertAfterAddingPeriodHolidayAt(date3);
    }
    @Test public void test06AddSpecificHolidayAndWeekly(){
        assertAfterAddingSpecificHoliday();
        assertAfterAddingWeeklyHoliday();
    }
    @Test public void test07AddSpecificHolidayAndPeriod(){
        agenda.addSpecificHoliday(date3);
        assertTwiceAfterAddingAPeriodHolidayAt(date2);
        assertTrue(agenda.isHoliday(date3));
    }
    @Test public void test08AddWeeklyHolidayAndPeriod(){
        agenda.addWeeklyHoliday(sunday);
        assertTwiceAfterAddingAPeriodHolidayAt(date3);
    }

    @Test public void test09CheckForDateThatIsNotHoliday(){
        assertFalse(agenda.isHoliday(LocalDate.of(2019, 3, 25)));
    }
    @Test public void test10CheckDateThatIsNotHolidayAfterAddingHoliday(){
        agenda.addSpecificHoliday(date3);
        assertFalse(agenda.isHoliday(date1));
    }
    @Test public void test11RegisteringExistingSpecificHolidayDoesNotThrowError(){
        agenda.addSpecificHoliday(date1);
        assertAfterAddingSpecificHoliday();
    }
    @Test public void test12RegisteringExistingWeeklyHolidayDoesNotThrowError(){
        agenda.addWeeklyHoliday(sunday);
        assertAfterAddingWeeklyHoliday();
    }
    @Test public void test13RegisteringExistingPeriodHolidayDoesNotThrowError(){
        agenda.addPeriodHoliday(date1, date2);
        assertAfterAddingPeriodHolidayAt(date1);
    }
    private void assertAfterAddingPeriodHolidayAt(LocalDate date1) {
        agenda.addPeriodHoliday(date1, date2);
        assertTrue(agenda.isHoliday(date1));
    }
    private void assertAfterAddingSpecificHoliday() {
        agenda.addSpecificHoliday(date1);
        assertTrue(agenda.isHoliday(date1));
    }
    private void assertAfterAddingWeeklyHoliday() {
        agenda.addWeeklyHoliday(sunday);
        assertTrue(agenda.isHoliday(sunday));
    }
    private void assertTwiceAfterAddingAPeriodHolidayAt(LocalDate date3) {
        assertAfterAddingPeriodHolidayAt(date1);
        assertTrue(agenda.isHoliday(date3));
    }
}
