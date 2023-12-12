import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class AgendaTest {
    @Test
    public void test00NewAgendaIsEmpty() {
        Agenda agenda = new Agenda();
        assertEquals(0, agenda.size());
    }

    @Test public void test01AddOneDayHoliday() {
        Agenda agenda = new Agenda();
        agenda.addHoliday(LocalDate.of(2017, 12, 25));
        assertEquals(1, agenda.size());
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 25)));
    }

    @Test public void test02AddPeriodHoliday() {
        Agenda agenda = new Agenda();
        agenda.addHoliday(LocalDate.of(2017, 12, 25), LocalDate.of(2017, 12, 31));
        assertEquals(1, agenda.size());
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 25)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 26)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 27)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 28)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 29)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 30)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
    }

    @Test public void test03AddWeekHoliday(){
        Agenda agenda = new Agenda();
        agenda.addHoliday(DayOfWeek.SUNDAY);
    }

    @Test public void test04AddOneDayHolidayAndWeekHoliday(){
        Agenda agenda = new Agenda();
        agenda.addHoliday(LocalDate.of(2017, 12, 25));
        agenda.addHoliday(DayOfWeek.SUNDAY);
        assertEquals(2, agenda.size());
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 25)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
    }

    @Test public void test05AddPeriodHolidayAndWeekHoliday(){
        Agenda agenda = new Agenda();
        agenda.addHoliday(LocalDate.of(2017, 12, 25), LocalDate.of(2017, 12, 31));
        agenda.addHoliday(DayOfWeek.SUNDAY);
        assertEquals(2, agenda.size());
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 25)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 26)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 27)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 28)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 29)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 30)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
    }

    @Test public void test06AddOneDayHolidayAndPeriodHoliday(){
        Agenda agenda = new Agenda();
        agenda.addHoliday(LocalDate.of(2017, 12, 25));
        agenda.addHoliday(LocalDate.of(2017, 12, 26), LocalDate.of(2017, 12, 31));
        assertEquals(2, agenda.size());
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 25)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 26)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 27)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 28)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 29)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 30)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
    }

    @Test public void test07AddWeekHolidayAndPeriodHolidayAndOneDayHoliday(){
        Agenda agenda = new Agenda();
        agenda.addHoliday(DayOfWeek.SUNDAY);
        agenda.addHoliday(LocalDate.of(2017, 12, 25), LocalDate.of(2017, 12, 31));
        agenda.addHoliday(LocalDate.of(2017, 12, 26));
        assertEquals(3, agenda.size());
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 25)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 26)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 27)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 28)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 29)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 30)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
        assertTrue(agenda.isHoliday(LocalDate.of(2017, 12, 31)));
    }

    @Test public void test08NoHolidayWhenItIsNotAdded(){
        Agenda agenda = new Agenda();
        agenda.addHoliday(DayOfWeek.SUNDAY);
        agenda.addHoliday(LocalDate.of(2017, 12, 25), LocalDate.of(2017, 12, 31));
        agenda.addHoliday(LocalDate.of(2017, 12, 26));
        assertEquals(3, agenda.size());
        assertFalse(agenda.isHoliday(LocalDate.of(2005, 12, 24)));
    }
}
