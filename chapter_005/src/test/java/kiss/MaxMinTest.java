package kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    MaxMin testClass;

    @Before
    public void setup() {
        testClass = new MaxMin();
    }


    @Test
    public void minTest() {
        Comparator<String> comparator = Comparator.comparing(t -> t.length());
        List<String> array = Arrays.asList("one", "tr", "three", "four");
        var result = testClass.min(array,
                comparator);
        assertThat(result, is("tr"));
    }

    @Test
    public void max() {
        Comparator<Integer> comparator = Comparator.comparing(t -> t);
        List<Integer> array = Arrays.asList(1, 2, 3, 4);
        var result = testClass.max(array,
                comparator);
        assertThat(result, is(4));
    }

}