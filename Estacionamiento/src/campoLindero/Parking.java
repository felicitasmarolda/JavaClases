package campoLindero;

import java.util.ArrayList;

public class Parking {
    public ArrayList<Car> cars = new ArrayList();
    public int people;
    public int totalToCharge;
    public Parking(){
        this.cars = new ArrayList<Car>();
        this.people = 0;
        this.totalToCharge = 0;
}
    public void addCar(Car car){
        cars.add(car);
        people += car.peopleInCar();
        totalToCharge += car.price();
    }
}
