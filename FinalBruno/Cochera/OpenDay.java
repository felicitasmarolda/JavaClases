package Cochera;

import java.util.ArrayList;


public class OpenDay extends DayState {


    private ArrayList<Car> cars = new ArrayList<>();

    public OpenDay() {
        cars.add(new NullCar(null));
    }


    public DayState addMeetingCarFor(String string) {
        cars.add(new MeetingCar(string));
        return this;
    }

    public DayState addClassCarFor(String string) {
        cars.add(new ClassCar(string));
        return this;
    }

    public DayState addPersonalCarFor(String string) {
        cars.add(new PersonalCar(string));
        return this;
    }   

    public boolean isOpen() {
        return true;
    }

    public String carParked() {
        throw new RuntimeException(Cochera.DayStillOpenErrorMessage);
    }

    public DayState closeDay(){
        return new CloseDay( selectCar()  );
    }

    private Car selectCar() {
        return cars.stream()
                .reduce((car1, car2) -> car1.hasLessPriorityThan(car2) ? car2 : car1)
                .orElse(cars.get(0));
    }
}
