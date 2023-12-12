package campoLindero;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;


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

    // falta unpark y que pasa con eso
    public void unpark( Car earlyCar ) {
        cars.removeAll( cars.stream().filter( (parked) -> parked.holds( earlyCar ) ).collect(toList()) );
    }
}
