package kiss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T sravn(List<T> value, Comparator<T> comparator,  Predicate<Integer> predicate) {
        T result = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (predicate.test(comparator.compare(result, value.get(i)))) {
                result = value.get(i);
            }
        }
        return result;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicateMax = p -> p < 0;
        return sravn(value, comparator, predicateMax);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicateMin = p -> p > 0;
        return sravn(value, comparator, predicateMin);
    }

}
