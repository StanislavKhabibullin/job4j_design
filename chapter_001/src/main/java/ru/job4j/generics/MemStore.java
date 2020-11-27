package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
                mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (T rsl:mem
             ) {
            if (rsl.getId() == id) {
                rsl = model;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int i = 0;
        for (T rsl:mem
        ) {
            if (rsl.getId() == id) {
                mem.remove(i);
                return true;
            }
            i++;
        }

        return false;
    }

    @Override
    public T findById(String id) {
        for (T rsl:mem
        ) {
            if (rsl.getId() == id) {
                return rsl;
            }
        }
        return null;
    }
}
