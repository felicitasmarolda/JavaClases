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
    @Test public void test01addGuestToParking() {
        Parking parking = new Parking();
        Car car = new Guest(1);
        parking.addCar(car);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.people);
        assertEquals(150, parking.totalToCharge);
    }
    @Test public void test02addMemberToParking() {
        Parking parking = new Parking();
        Car car = new Member(1);
        parking.addCar(car);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.people);
        assertEquals(100, parking.totalToCharge);
    }
    @Test public void test03addIndividualToParking() {
        Parking parking = new Parking();
        Car car = new Individual(1);
        parking.addCar(car);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.people);
        assertEquals(80, parking.totalToCharge);
    }

    @Test public void test04addTwoCarsToParking() {
        Parking parking = new Parking();
        Car car1 = new Guest(1);
        Car car2 = new Member(2);
        parking.addCar(car1);
        parking.addCar(car2);
        assertEquals(2, parking.cars.size());
        assertEquals(3, parking.people);
        assertEquals(250, parking.totalToCharge);
    }
    @Test public void test05addThreeCarsToParking() {
        Parking parking = new Parking();
        Car car1 = new Guest(1);
        Car car2 = new Member(2);
        Car car3 = new Individual(3);
        parking.addCar(car1);
        parking.addCar(car2);
        parking.addCar(car3);
        assertEquals(3, parking.cars.size());
        assertEquals(6, parking.people);
        assertEquals(480, parking.totalToCharge);
    }


}
