package kiss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T sravn(List<T> value, Comparator<T> comparator, String maxMin) {
        T resultMin = value.get(0);
        T resultMax = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(resultMax, value.get(i)) < 0) {
                resultMax = value.get(i);
            }
            if (comparator.compare(resultMin, value.get(i)) > 0) {
                resultMin = value.get(i);
            }
        }
        if (maxMin.equals("max")) {
            return resultMax;
        }
        return resultMin;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
       /* T maxik = value.get(0);
        for (int i = 1; i < value.size(); i++) {
           if (comparator.compare(maxik, value.get(i)) <  0) {
                 maxik = value.get(i);
           }
        }
        return maxik;

        */
        return sravn(value, comparator, "max");
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        /* T minik = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(minik, value.get(i)) >  0) {
                     minik = value.get(i);
            }
        }
        return minik;

         */
        return sravn(value, comparator, "min");
    }

}
