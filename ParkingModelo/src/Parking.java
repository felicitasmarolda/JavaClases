import java.util.ArrayList;

public class Parking {
    ArrayList<Car> cars = new ArrayList<Car>();

    private int peopleInEvent = 0;
    public int peopleInEvent() {
        return peopleInEvent;
    }

    public int moneyToBeEarned() {
        return moneyToBeEarned;
    }
    private int moneyToBeEarned = 0;

    public void park(Car car) {
        cars.add(car);
        peopleInEvent += car.getPeopleInCar();
        moneyToBeEarned += car.getMoneyToBeEarned();
    }

    public void unpark(Car car) {
        cars.stream()
                .filter(c -> c.equals(car))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found"));
        cars.remove(car);
        peopleInEvent -= car.getPeopleInCar();
        moneyToBeEarned -= car.getMoneyToBeEarned();
    }

}
