import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingTest {
    @Test
    public void test00ParkingBeginsEmpty(){
        Parking parking = new Parking();
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test01ParkingCanParkPartners(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        parking.park(partners);
        assertEquals(1, parking.cars.size());
        assertEquals(2, parking.peopleInEvent());
        assertEquals(100, parking.moneyToBeEarned());
    }

    @Test public void test02ParkingCanParkPartnersFamilies(){
        Parking parking = new Parking();
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        parking.park(partnersFamilies);
        assertEquals(1, parking.cars.size());
        assertEquals(4, parking.peopleInEvent());
        assertEquals(150, parking.moneyToBeEarned());
    }

    @Test public void test03ParkingCanParkNewcommers(){
        Parking parking = new Parking();
        Newcommers newcommers = new Newcommers(1);
        parking.park(newcommers);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.peopleInEvent());
        assertEquals(110, parking.moneyToBeEarned());
    }

    @Test public void test04ParkingCanParkPartersAndPartnersFamilies(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        parking.park(partners);
        parking.park(partnersFamilies);
        assertEquals(2, parking.cars.size());
        assertEquals(6, parking.peopleInEvent());
        assertEquals(250, parking.moneyToBeEarned());
    }

    @Test public void test05ParkingCanPartPartnersAndNewcommers(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partners);
        parking.park(newcommers);
        assertEquals(2, parking.cars.size());
        assertEquals(3, parking.peopleInEvent());
        assertEquals(210, parking.moneyToBeEarned());
    }

    @Test public void test06ParkingCanParkPartnersFamiliesAndNewcommers(){
        Parking parking = new Parking();
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partnersFamilies);
        parking.park(newcommers);
        assertEquals(2, parking.cars.size());
        assertEquals(5, parking.peopleInEvent());
        assertEquals(260, parking.moneyToBeEarned());
    }

    @Test public void test07ParkingCanParkPartnersPartnersFamiliesAndNewcommers(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partners);
        parking.park(partnersFamilies);
        parking.park(newcommers);
        assertEquals(3, parking.cars.size());
        assertEquals(7, parking.peopleInEvent());
        assertEquals(360, parking.moneyToBeEarned());
    }

    @Test public void test08ParkingCanUnparkPartners(){
        Parking parking = new Parking();
        Partners partners = new Partners(3);
        parking.park(partners);
        assertEquals(1, parking.cars.size());
        assertEquals(3, parking.peopleInEvent());
        assertEquals(100, parking.moneyToBeEarned());
        parking.unpark(partners);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test09ParkingCanUnparkPartnersFamilies(){
        Parking parking = new Parking();
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        parking.park(partnersFamilies);
        assertEquals(1, parking.cars.size());
        assertEquals(4, parking.peopleInEvent());
        assertEquals(150, parking.moneyToBeEarned());
        parking.unpark(partnersFamilies);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test10ParkingCanUnparkNewcommers(){
        Parking parking = new Parking();
        Newcommers newcommers = new Newcommers(1);
        parking.park(newcommers);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.peopleInEvent());
        assertEquals(110, parking.moneyToBeEarned());
        parking.unpark(newcommers);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test11ParkingCanUnparkPartnersAndPartnersFamilies(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        parking.park(partners);
        parking.park(partnersFamilies);
        assertEquals(2, parking.cars.size());
        assertEquals(6, parking.peopleInEvent());
        assertEquals(250, parking.moneyToBeEarned());
        parking.unpark(partners);
        assertEquals(1, parking.cars.size());
        assertEquals(4, parking.peopleInEvent());
        assertEquals(150, parking.moneyToBeEarned());
        parking.unpark(partnersFamilies);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test12ParkingCanUnparkPartnersAndNewcommers(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partners);
        parking.park(newcommers);
        assertEquals(2, parking.cars.size());
        assertEquals(3, parking.peopleInEvent());
        assertEquals(210, parking.moneyToBeEarned());
        parking.unpark(partners);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.peopleInEvent());
        assertEquals(110, parking.moneyToBeEarned());
        parking.unpark(newcommers);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test13ParkingCanUnparkPartnersFamiliesAndNewcommers(){
        Parking parking = new Parking();
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partnersFamilies);
        parking.park(newcommers);
        assertEquals(2, parking.cars.size());
        assertEquals(5, parking.peopleInEvent());
        assertEquals(260, parking.moneyToBeEarned());
        parking.unpark(partnersFamilies);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.peopleInEvent());
        assertEquals(110, parking.moneyToBeEarned());
        parking.unpark(newcommers);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test14ParkingCanUnparkPartnersPartnersFamiliesAndNewcommers(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partners);
        parking.park(partnersFamilies);
        parking.park(newcommers);
        assertEquals(3, parking.cars.size());
        assertEquals(7, parking.peopleInEvent());
        assertEquals(360, parking.moneyToBeEarned());
        parking.unpark(partners);
        assertEquals(2, parking.cars.size());
        assertEquals(5, parking.peopleInEvent());
        assertEquals(260, parking.moneyToBeEarned());
        parking.unpark(partnersFamilies);
        assertEquals(1, parking.cars.size());
        assertEquals(1, parking.peopleInEvent());
        assertEquals(110, parking.moneyToBeEarned());
        parking.unpark(newcommers);
        assertEquals(0, parking.cars.size());
        assertEquals(0, parking.peopleInEvent());
        assertEquals(0, parking.moneyToBeEarned());
    }

    @Test public void test15ParkingCanNotNonParkedCar(){
        Parking parking = new Parking();
        Partners partners = new Partners(2);
        PartnersFamilies partnersFamilies = new PartnersFamilies(4);
        Newcommers newcommers = new Newcommers(1);
        parking.park(partners);
        parking.park(partnersFamilies);
        parking.park(newcommers);
        parking.unpark(partners);
        parking.unpark(partnersFamilies);
        parking.unpark(newcommers);
        try {
            parking.unpark(partners);
        } catch (RuntimeException e) {
            assertEquals("Car not found", e.getMessage());
        }
    }


}
