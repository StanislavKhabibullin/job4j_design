package solid.lsp.carparking;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ParkingTest {

    @Test
    public void parking() {
        Auto car = new Car();
        Auto truck = new Truck();
        Parking parking = new UndergroundParking();
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(true));

    }
}