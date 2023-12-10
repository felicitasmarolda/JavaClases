package Cochera;

public class ClassCar extends Car {
    public ClassCar(String plate) {
        super(plate);
    }

    public boolean morePriorityThanPersonalCar() {
        return true;
    }

    public boolean hasLessPriorityThan(Car car) {
        return car.morePriorityThanClassCar();
    }

}
