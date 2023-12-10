package Cochera;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Cochera {
    public Map<LocalDate, Days> daysMap = new HashMap<>();

    public static String DayStillOpenErrorMessage = "El dia Todavia sigue abierto";
    public static String CannotParkInClosedDayErrorMessage = "No se puede estacionar en un dia cerrado";
    public static String dayClosedWithNoCarErroMessage = "No hay Auto estacionado";
    public static String CarAlreadyWaitingErrorMessage = "El Auto ya esta en lista";

    public Cochera addMeetingCarFor(LocalDate day, String string) {
        daysMap.computeIfAbsent(day, Days::new)
                .addMeetingCarFor(string);
        return this;
    }

    public Cochera addClassCarFor(LocalDate day, String string) {
        daysMap.computeIfAbsent(day, Days::new)
                .addClassCarFor(string);
        return this;
    }

    public Cochera addPersonalCarFor(LocalDate day, String string) {
        daysMap.computeIfAbsent(day, Days::new)
                .addPersonalCarFor(string);
        return this;
    }

    public void closeDay(LocalDate day) {
        daysMap.computeIfAbsent(day, Days::new)
                .closeDay();
    }

    public String carParkedOn(LocalDate day) {
        return daysMap.getOrDefault(day, new Days(day))
                .carParked();
    }

    public boolean isOpen(LocalDate day) {
        return daysMap.getOrDefault(day, new Days(day))
                .isOpen();
    }
}
