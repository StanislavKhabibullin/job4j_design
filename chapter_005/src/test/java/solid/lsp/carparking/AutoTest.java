package solid.lsp.carparking;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
public class AutoTest {

    @Test
    public void size() {
        Auto car = new Car();
        Auto truck = new Truck();
        int carRes = car.size();
        int truckRes = truck.size();
        assertThat(carRes, is(1));
        assertThat(truckRes, is(3));

    }
}