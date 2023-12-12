package Agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyHoliday extends Holiday{
    DayOfWeek dayOfWeek;
    public WeeklyHoliday(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    @Override
    public boolean isHoliday(LocalDate date) {
        return this.dayOfWeek == date.getDayOfWeek();
    }

    @Override
    public boolean isHoliday(DayOfWeek dayOfWeek) {
        return this.dayOfWeek == dayOfWeek;
    }
}
