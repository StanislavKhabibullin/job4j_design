package ru.job4j.it;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> coursor = Collections.emptyIterator();
    //private List<T> temp = new ArrayList<>();


    public FlatMap(Iterator<Iterator<T>> data) {
                this.data = data;
       /* while (data.hasNext()) {
            Iterator<T> inner = data.next();
            while (inner.hasNext()) {
                temp.add(inner.next());
            }
        }
        coursor = temp.iterator(); */
    }

    @Override
    public boolean hasNext() {
        while (!coursor.hasNext()&& data.hasNext()) {
                coursor = data.next();
           }
            return coursor.hasNext();
        }
       /* if (coursor == null) {
            coursor = data.next();
        }
        if (!coursor.hasNext() && !data.hasNext()) {
            return false;
        }
        if (!coursor.hasNext() && data.hasNext()) {
            coursor = data.next();

        }
        return coursor.hasNext(); */


    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return coursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.print(flat.next());
        }
    }
}
