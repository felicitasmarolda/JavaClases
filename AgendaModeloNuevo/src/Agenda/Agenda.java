package Agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {
    ArrayList<Holiday> feriados = new ArrayList<Holiday>();
    public void addSpecificHoliday(LocalDate date) {
        feriados.add(new SpecificHoliday(date));
    }
    public void addWeeklyHoliday(DayOfWeek dayOfWeek) {
        feriados.add(new WeeklyHoliday(dayOfWeek));
    }
    public void addPeriodHoliday(LocalDate start, LocalDate end) {
        feriados.add(new PeriodHoliday(start, end));
    }
    public boolean isHoliday(LocalDate date){
        return feriados.stream().anyMatch(feriado -> feriado.isHoliday(date));
    }
    public boolean isHoliday(DayOfWeek dayOfWeek){
        return feriados.stream().anyMatch(feriado -> feriado.isHoliday(dayOfWeek));
    }
}
