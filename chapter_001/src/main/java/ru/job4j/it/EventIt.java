package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt implements Iterator<Integer> {
    private final int[] data;
    private int rsl = 0;

    public EventIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = rsl; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    /*    for (int i = rsl; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = i;
                break;
            }
        } */
        return data[rsl++];
    }
}
