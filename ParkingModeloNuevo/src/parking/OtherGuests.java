package parking;

public class OtherGuests extends ParkedCar{
    public OtherGuests(Car car) {
        super(car);
    }

    @Override
    public int fee() {
        return 50 + 60 * car.getGuests();
    }
}
