package Cochera;

public class MeetingCar extends Car {

    public MeetingCar(String plate) {
        super(plate);
    }

    public boolean morePriorityThanPersonalCar() {
        return true;
    }

    public boolean morePriorityThanClassCar() {
        return true;
    }

    public boolean hasLessPriorityThan(Car car) {
        return car.morePriorityThanMeetingCar();
    }
}
