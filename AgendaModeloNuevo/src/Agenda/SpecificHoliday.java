package Agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecificHoliday extends Holiday{
    LocalDate date;
    public SpecificHoliday(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean isHoliday(LocalDate date) {
        return this.date == date;
    }

    @Override
    public boolean isHoliday(DayOfWeek dayOfWeek) {
        return false;
    }
}
