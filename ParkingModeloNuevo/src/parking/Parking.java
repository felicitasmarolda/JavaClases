package parking;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Parking {
    ArrayList<ParkedCar> carsInParkingLot = new ArrayList<ParkedCar>();
    public Parking(){
    }
    public int getGuests(){
        int count = carsInParkingLot.stream()
                .mapToInt(parkedCar -> parkedCar.getCar().getGuests())
                .sum();
        return count;
    }
    public int getMoney(){
        int count = carsInParkingLot.stream()
                .mapToInt(ParkedCar::fee)
                .sum();

        return count;
    }
    public void parkPartner(Car car){
        carsInParkingLot.add(new Partner(car));
    }
    public void parkPartnersFamilies(Car car){
        carsInParkingLot.add(new PartnersFamilies(car));
    }
    public void parkOtherGuests(Car car){
        carsInParkingLot.add(new OtherGuests(car));
    }
    public void unpark(Car car) {
        if (!checkIfCarIsParked(car)) {
            throw new RuntimeException("Car is not parked");
        }
        for (ParkedCar parkedCar : carsInParkingLot) {
            if (parkedCar.getCar().equals(car)) {
                carsInParkingLot.remove(parkedCar);
                break;
            }
        }
    }
    private boolean checkIfCarIsParked(Car car){
        return carsInParkingLot.stream().anyMatch(parkedCar -> parkedCar.getCar().equals(car));
    }


}
