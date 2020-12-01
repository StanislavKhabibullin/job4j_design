package ru.job4j.generics;

import com.sun.jdi.Value;

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
        int index = findIndexById(id);
        if (index != - 1) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int i = findIndexById(id);
        if (i != - 1) {
                mem.remove(i);
                return true;
            }
        return false;
    }

    @Override
    public T findById(String id) {
        int rsl = findIndexById(id);
          if (rsl != - 1) {
                return mem.get(rsl);
            }
        return null;
    }

    public int findIndexById(String id) {
        int i = 0;
        for (T rsl:mem
        ) {
            if (rsl.getId().equals(id)) {
                return i;
            }
            i++;
        }
        return - 1;
    }
}
