package parking;

public abstract class ParkedCar {
    protected Car car;
    public ParkedCar(Car car){
        this.car = car;
    }
    public Car getCar(){
        return car;
    }
    public abstract int fee();
    public int getGuests(){
        return car.getGuests();
    }
}
