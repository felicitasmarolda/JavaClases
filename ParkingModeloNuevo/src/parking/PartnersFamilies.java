package parking;

public class PartnersFamilies extends ParkedCar{
    public PartnersFamilies(Car car) {
        super(car);
    }

    @Override
    public int fee() {
        return 150;
    }
}
