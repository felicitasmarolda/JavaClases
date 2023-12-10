package Cochera;

import java.time.LocalDate;

public class CloseDay extends DayState{
    private Car car;

    public CloseDay(Car car) {
        this.car = car;
    }

    
    public DayState addMeetingCarFor(String string) {
        throw new RuntimeException(Cochera.CannotParkInClosedDayErrorMessage);
    }
    public DayState addClassCarFor(String string) {
        throw new RuntimeException(Cochera.CannotParkInClosedDayErrorMessage);
    }
    public DayState addPersonalCarFor(String string) {
        throw new RuntimeException(Cochera.CannotParkInClosedDayErrorMessage);
    }
    public boolean isOpen() {
        return false;
    }
    public String carParked() {
        return car.getPlate();
    }
    public DayState closeDay(){
        return this;
    }
}
