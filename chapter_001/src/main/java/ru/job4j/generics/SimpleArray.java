package ru.job4j.generics;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
   private T[] items;
   private int count = 0;



    public SimpleArray(int size) {
      this.items = (T[]) new Object[size];
   }

  /*  public SimpleArray(T[] items) {
        this.items = items;
        this.count = items.length;
    }

   */
    void add(T model) {

        items[count++] = model;
    }

    void set(int index, T model) {
       Objects.checkIndex(index, count);
       this.items[index] = model;
    }

    void remove(int index) {
       Objects.checkIndex(index, count);
       /* T[] mas1 = (T[]) new Object[this.items.length - 1];
        if (index != 0) {
         System.arraycopy(this.items, 0, mas1, 0, index );
         System.arraycopy(this.items, index + 1, mas1, index, count - index - 1 );
        }
        if (index == 0) {
            System.arraycopy(this.items, 1, mas1, 0, count - 1 );
        }
        this.items = mas1;

        */

        System.arraycopy(this.items, index + 1, this.items, index, count - index - 1);
        this.items[count - 1] = null;
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);

        return items[index];
    }


    @Override
    public Iterator<T> iterator() {
          return new Iterator<T>() {
              int position = 0;
            @Override
            public boolean hasNext() {
                return position < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return items[position++];
            }
        };
    }



    @Override
    public String toString() {
        List<String> value = new ArrayList<>();
        for (T rsl
                : this.items) {
            value.add(String.valueOf(rsl));
        }
        return value.toString();
    }

    public static void main(String[] args) {
        SimpleArray<String> words = new SimpleArray<>(10);
        words.add("first");
        words.add("second");
        words.add("third");
        words.add("first");
        words.add("first");

        System.out.println(words);
        words.add("sixth");
        System.out.println(words);
        words.remove(3);
        System.out.println(words);
        System.out.println(words.get(3));
        words.set(3, "forth");
        System.out.println(words);

        Iterator<String> iterator = words.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
