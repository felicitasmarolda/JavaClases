package Agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class PeriodHoliday extends Holiday{
    LocalDate start;
    LocalDate end;
    public PeriodHoliday(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public boolean isHoliday(LocalDate date) {
        return date.isAfter(start) && date.isBefore(end) || date.isEqual(start) || date.isEqual(end);
    }

    @Override
    public boolean isHoliday(DayOfWeek dayOfWeek) {
        return IntStream.iterate(0, i -> i + 1)
                .mapToObj(start::plusDays)
                .takeWhile(date -> date.isBefore(end))
                .anyMatch(date -> date.getDayOfWeek() == dayOfWeek);
    }
}
