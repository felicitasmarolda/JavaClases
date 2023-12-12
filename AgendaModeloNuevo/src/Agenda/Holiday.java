package Agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Holiday {
    public abstract boolean isHoliday(LocalDate date);
    public abstract boolean isHoliday(DayOfWeek dayOfWeek);
}
