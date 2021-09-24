package solid.lsp.carparking;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ParkingTest {

    @Test
    public void parking() {
        Auto car = new Car();
        Auto truck = new Truck(3);
        Parking parking = new UndergroundParking(3, 1);
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(true));

    }

    @Test
    public void noPlaceForTruck1() {
        Auto car = new Car();
        Auto truck = new Truck(3);
        Parking parking = new UndergroundParking(10, 0);
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(true));
    }

    @Test
    public void noPlaceForTruck2() {
        Auto car = new Car();
        Auto truck = new Truck(3);
        Parking parking = new UndergroundParking(3, 0);
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(false));

    }
}