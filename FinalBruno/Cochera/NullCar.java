package Cochera;

public class NullCar extends Car{
   
    
    public NullCar(String plate) {
        super(plate);
    }

    public boolean morePriorityThanMeetingCar() {
        return false;
    }

    public boolean morePriorityThanPersonalCar() {
        return false;
    }

    public boolean morePriorityThanClassCar() {
        return false;
    }

    public boolean hasLessPriorityThan(Car car) {
        return true;
    }
    public String getPlate(){
        throw new RuntimeException(Cochera.dayClosedWithNoCarErroMessage);
    }
    
}
