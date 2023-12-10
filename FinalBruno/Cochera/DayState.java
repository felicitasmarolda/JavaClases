package Cochera;

import java.time.LocalDate;

public abstract class DayState {
    public abstract DayState addMeetingCarFor(String string);
    public abstract DayState addClassCarFor(String string);
    public abstract DayState addPersonalCarFor(String string);
    public abstract boolean isOpen();
    public abstract String carParked();
    public abstract DayState closeDay();
}
