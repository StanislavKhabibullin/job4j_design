package solid.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class TrashTest {

    @Test
    public void acceptTest() {
        Food whiteBread = new Bread("Baguette", LocalDate.of(2021, 9, 11),
                LocalDate.of(2021, 9, 10), 150, 0);
        Food blackBread = new Bread("Bojole", LocalDate.of(2021, 10, 22),
                LocalDate.of(2021, 9, 10), 100, 0);
        Trash test = new Trash();
        if (test.accept(whiteBread)) {
            test.addStore(whiteBread);
        }
        if (test.accept(blackBread)) {
            test.addStore(blackBread);
        }
        Food res = test.getFromStore().get(0);
        assertThat(res, is(whiteBread));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void notAcceptTest() {
        Food blackBread = new Bread("Bojole", LocalDate.of(2021, 10, 22),
                LocalDate.of(2021, 9, 10), 100, 0);
        Trash test = new Trash();
        if (test.accept(blackBread)) {
            test.addStore(blackBread);
        }
        Food res = test.getFromStore().get(0);
        assertThat(res, is(0));
    }
}