package campoLindero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingTest {
    @Test public void test00newParkingIsEmpty() {
        Parking parking = new Parking();
           assertEquals(0, parking.cars.size());
           assertEquals(0, parking.people);
           assertEquals(0, parking.totalToCharge);
    }
    @Test public void test01addCarToParking() {
        Parking parking = new Parking();
        parking.addCar(new Guest(1));
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.people);
        assertEquals(150, parking.totalToCharge);
    }
    @Test public void test02addTwoCarsToParking() {
        Parking parking = new Parking();
        parking.addCar(new Guest(1));
        parking.addCar(new Member(2));
        assertEquals(2, parking.cars.size());
        assertEquals(3, parking.people);
        assertEquals(250, parking.totalToCharge);
    }

}
