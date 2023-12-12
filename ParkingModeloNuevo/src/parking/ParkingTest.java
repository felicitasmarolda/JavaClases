package parking;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;
import static org.junit.Assert.assertEquals;

public class ParkingTest {
    @Test
    public void test00ParkingWithNoCarsHayNoMoneyAndNoGuests(){
        Parking parking = new Parking();
        assertEquals(0, parking.getMoney());
        assertEquals(0, parking.getGuests());
    }
    @Test public void test01ParkingParkingPartnerWellRegistered(){
        Parking parking = new Parking();
        Car car = new Car(1);
        parking.parkPartner(car);
        assertEquals(100, parking.getMoney());
        assertEquals(1, parking.getGuests());
    }
    @Test public void test02ParkingPartnersFamiliesWellRegistered(){
        Parking parking = new Parking();
        Car car = new Car(2);
        parking.parkPartnersFamilies(car);
        assertEquals(150, parking.getMoney());
        assertEquals(2, parking.getGuests());
    }
    @Test public void test03ParkingOtherGuestsWellRegistered(){
        Parking parking = new Parking();
        Car car = new Car(1);
        parking.parkOtherGuests(car);
        assertEquals(110, parking.getMoney());
        assertEquals(1, parking.getGuests());
    }
    @Test public void test04ParkingPartnersAndPartnersFamiliesWellRegistered(){
        Parking parking = new Parking();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        parking.parkPartner(car1);
        parking.parkPartnersFamilies(car2);
        assertEquals(250, parking.getMoney());
        assertEquals(3, parking.getGuests());
    }
    @Test public void test05ParkingPartnersAndOtherGuestsWellRegistered(){
        Parking parking = new Parking();
        Car car1 = new Car(1);
        Car car2 = new Car(1);
        parking.parkPartner(car1);
        parking.parkOtherGuests(car2);
        assertEquals(210, parking.getMoney());
        assertEquals(2, parking.getGuests());
    }
    @Test public void test06ParkingPartnersFamiliesAndOtherGuestsWellRegistered(){
        Parking parking = new Parking();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        parking.parkPartnersFamilies(car2);
        parking.parkOtherGuests(car1);
        assertEquals(260, parking.getMoney());
        assertEquals(3, parking.getGuests());
    }
    @Test public void test07ParkingPartnersPartnersFamiliesAndOtherGuestsWellRegistered(){
        Parking parking = new Parking();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(1);
        parking.parkPartner(car1);
        parking.parkPartnersFamilies(car2);
        parking.parkOtherGuests(car3);
        assertEquals(360, parking.getMoney());
        assertEquals(4, parking.getGuests());
    }
    @Test public void test08UnparkingPartnersWellRegistered(){
        Parking parking = new Parking();
        Car car = new Car(1);
        parking.parkPartner(car);
        assertEquals(100, parking.getMoney());
        assertEquals(1, parking.getGuests());
        parking.unpark(car);
        assertEquals(0, parking.getMoney());
        assertEquals(0, parking.getGuests());
    }
    @Test public void test09UnparkingPartnersFamiliesWellRegistered(){
        Parking parking = new Parking();
        Car car = new Car(2);
        parking.parkPartnersFamilies(car);
        assertEquals(150, parking.getMoney());
        assertEquals(2, parking.getGuests());
        parking.unpark(car);
        assertEquals(0, parking.getMoney());
        assertEquals(0, parking.getGuests());
    }
    @Test public void test10UnparkingOtherGuestsWellRegistered(){
        Parking parking = new Parking();
        Car car = new Car(1);
        parking.parkOtherGuests(car);
        assertEquals(110, parking.getMoney());
        assertEquals(1, parking.getGuests());
        parking.unpark(car);
        assertEquals(0, parking.getMoney());
        assertEquals(0, parking.getGuests());
    }
    @Test public void test11UnparkingPartnersAndPartnersFamiliesWellRegistered(){
        Parking parking = new Parking();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        parking.parkPartner(car1);
        parking.parkPartnersFamilies(car2);
        assertEquals(250, parking.getMoney());
        assertEquals(3, parking.getGuests());
        parking.unpark(car1);
        assertEquals(150, parking.getMoney());
        assertEquals(2, parking.getGuests());
        parking.unpark(car2);
        assertEquals(0, parking.getMoney());
        assertEquals(0, parking.getGuests());
    }
    @Test public void test12ParkingAndUnparkingMultipleCarsWellRegistered(){
        Parking parking = new Parking();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(1);
        parking.parkPartner(car1);
        parking.parkPartnersFamilies(car2);
        parking.parkOtherGuests(car3);
        assertEquals(360, parking.getMoney());
        assertEquals(4, parking.getGuests());
        parking.unpark(car1);
        assertEquals(260, parking.getMoney());
        assertEquals(3, parking.getGuests());
        parking.unpark(car2);
        assertEquals(110, parking.getMoney());
        assertEquals(1, parking.getGuests());
        parking.unpark(car3);
        Car car4 = new Car(7);
        parking.parkPartner(car4);
        assertEquals(100, parking.getMoney());
        assertEquals(7, parking.getGuests());
    }
    @Test public void test13CanNotUnparkNonParkedCar(){
        Parking parking = new Parking();
        Car car = new Car(1);
        assertThrowsLike(() -> parking.unpark(car), "Car is not parked");

    }
    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }


}
