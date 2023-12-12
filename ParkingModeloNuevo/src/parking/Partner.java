package parking;

public class Partner extends ParkedCar {
    public Partner(Car car) {
        super(car);
    }

    @Override
    public int fee() {
        return 100;
    }
}
