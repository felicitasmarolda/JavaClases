package Cochera;

import java.time.LocalDate;

public  class Days {
    
    private LocalDate date;
    private DayState state;
    
    public Days(LocalDate date){
        this.date = date;
        this.state = new OpenDay();
    }

    public Days addMeetingCarFor(String string) {
        state = state.addMeetingCarFor(string);
        return this;
    }

    public Days addClassCarFor(String string) {
        state = state.addClassCarFor(string);
        return this;
    }

    public Days addPersonalCarFor(String string) {
        state = state.addPersonalCarFor(string);
        return this;
    }

    public boolean isOpen() {
        return state.isOpen();
    }

    public String carParked() {
        return state.carParked();
    }

    public Days closeDay(){
        state = state.closeDay();
        return this;
    }

    public LocalDate getDay(){
        return date;
    }
}
