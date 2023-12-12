import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParkingTest {
    @Test
    public void test00ParkingBeginsEmpty(){
        assertParkingStatus(new Parking(),0,0,0);
    }

    @Test public void test01ParkingCanParkPartners(){
        assertParkingStatusAfterParking(new Parking(), 1,2,100, new Partners(2));
    }

    @Test public void test02ParkingCanParkPartnersFamilies(){
        assertParkingStatusAfterParking(new Parking(), 1,4,150, new PartnersFamilies(4));
    }

    @Test public void test03ParkingCanParkNewcommers(){
        assertParkingStatusAfterParking(new Parking(),1,1,110, new Newcommers(1));
    }

    @Test public void test04ParkingCanParkPartersAndPartnersFamilies(){
        assertParkingStatusAfterParking(new Parking(),2,6,250, new Partners(2), new PartnersFamilies(4));
    }

    @Test public void test05ParkingCanPartPartnersAndNewcommers(){
        assertParkingStatusAfterParking(new Parking(),2,3,210, new Partners(2), new Newcommers(1));
    }

    @Test public void test06ParkingCanParkPartnersFamiliesAndNewcommers(){
        assertParkingStatusAfterParking(new Parking(),2,5,260, new PartnersFamilies(4), new Newcommers(1));
    }

    @Test public void test07ParkingCanParkPartnersPartnersFamiliesAndNewcommers(){
        assertParkingStatusAfterParking(new Parking(),3,7,360, new Partners(2), new PartnersFamilies(4), new Newcommers(1));
    }

    @Test public void test08ParkingCanUnparkPartners(){
        Parking parking = new Parking();
        Partners partners = new Partners(3);
        assertParkingStatusAfterParking(parking,1,3,100, partners);
        assertParkingStatusAfterUnpark(parking, partners,0,0,0);
    }

    @Test public void test09ParkingCanUnparkPartnersFamilies(){
        Parking parking = new Parking();
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        assertParkingStatusAfterParking(parking,1,4,150, partnersFamilies);
        assertParkingStatusAfterUnpark(parking, partnersFamilies,0,0,0);
    }

    @Test public void test10ParkingCanUnparkNewcommers(){
        Parking parking = new Parking();
        Newcommers newcommers = new Newcommers(1);
        assertParkingStatusAfterParking(parking,1,1,110, newcommers);
        assertParkingStatusAfterUnpark(parking, newcommers,0,0,0);
    }

    @Test public void test11ParkingCanUnparkPartnersAndPartnersFamilies(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        assertParkingStatusAfterParking(parking,2,6,250, partnersFamilies, partners);
        assertParkingStatusAfterUnpark(parking, partners,1,4,150);
        assertParkingStatusAfterUnpark(parking, partnersFamilies,0,0,0);
    }

    @Test public void test12ParkingCanUnparkPartnersAndNewcommers(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        Newcommers newcommers = new Newcommers(1);
        assertParkingStatusAfterParking(parking,2,3,210, partners, newcommers);
        assertParkingStatusAfterUnpark(parking, partners,1,1,110);
        assertParkingStatusAfterUnpark(parking, newcommers,0,0,0);


    }

    @Test public void test13ParkingCanUnparkPartnersFamiliesAndNewcommers(){
        Parking parking = new Parking();
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        assertParkingStatusAfterParking(parking,2,5,260, partnersFamilies, newcommers);
        assertParkingStatusAfterUnpark(parking, partnersFamilies,1,1,110);
        assertParkingStatusAfterUnpark(parking, newcommers,0,0,0);

    }

    @Test public void test14ParkingCanUnparkPartnersPartnersFamiliesAndNewcommers(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        assertParkingStatusAfterParking(parking,3,7,360, partners, newcommers, partnersFamilies);
        assertParkingStatusAfterUnpark(parking, partners,2,5,260);
        assertParkingStatusAfterUnpark(parking, partnersFamilies,1,1,110);
        assertParkingStatusAfterUnpark(parking, newcommers,0,0,0);

    }

    @Test public void test15ParkingCanNotNonParkedCar(){
        Parking parking = new Parking();
        Partners partners = new Partners(1);
        parking.park(partners);
        parking.unpark(partners);
        try {
            parking.unpark(partners);
        } catch (RuntimeException e) {
            assertEquals("Car not found", e.getMessage());
        }
    }


    private static void assertParkingStatus(Parking parking, int cars, int peopleInEvent, int moneyToBeEarned) {
        assertEquals(cars, parking.cars.size());
        assertEquals(peopleInEvent, parking.peopleInEvent());
        assertEquals(moneyToBeEarned, parking.moneyToBeEarned());
    }

    private static void assertParkingStatusAfterParking(Parking parking,  int cars, int peopleInEvent, int moneyToBeEarned, Car ... carsToPark) {
        Arrays.stream(carsToPark).forEach(parking::park);
        assertParkingStatus(parking,cars,peopleInEvent,moneyToBeEarned);
    }
    private static void assertParkingStatusAfterUnpark(Parking parking, Car car, int cars, int peopleInEvent, int moneyToBeEarned) {
        parking.unpark(car);
        assertParkingStatus(parking,cars,peopleInEvent,moneyToBeEarned);
    }

}
