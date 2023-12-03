import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingTest {
    @Test
    public void test00ParkingBeginsEmpty(){
        Parking parking = new Parking();
        assertEquals(0, parking.cars.size());
    }
}
