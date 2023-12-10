package Cochera;

public class PersonalCar extends Car {
    public PersonalCar (String plate) {
        super(plate);
    }


    public boolean hasLessPriorityThan(Car car) {
        return car.morePriorityThanPersonalCar();
    }
}
