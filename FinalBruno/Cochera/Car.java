package Cochera;

public abstract class  Car {
    private String plate;

    public Car(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public  boolean morePriorityThanMeetingCar(){
        return false;
    };

    public  boolean morePriorityThanPersonalCar(){
        return false;
    };

    public  boolean morePriorityThanClassCar(){
        return false;
    };
    public abstract boolean hasLessPriorityThan(Car car );

    
}
