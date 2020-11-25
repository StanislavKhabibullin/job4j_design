package ru.job4j.generics;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
   private T[] items;
   private int count;
    private int position = 0;


    public SimpleArray(int size) {
      this.items = (T[]) new Object[size];
      count = size;
   }

    public SimpleArray(T[] items, int count) {
        this.items = items;
        this.count = count;
    }

    void add(T model) {
        items[count++] = model;
    }

    void set(int index, T model) {
       Objects.checkIndex(index, count);
       this.items[index] = model;
    }

    void remove(int index) {
       Objects.checkIndex(index, count);
        T[] mas1 = (T[]) new Object[this.items.length - 1];
        if (index != 0) {
         System.arraycopy(this.items, 0, mas1, 0, index );
         System.arraycopy(this.items, index + 1, mas1, index, count - index - 1 );
        }
        if (index == 0) {
            System.arraycopy(this.items, 1, mas1, 0, count - 1 );
        }
        this.items = mas1;
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        for (int i = 0; i < this.items.length; i++) {
            if (i == index) {
                return items[i];
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
        for (T rsl:
             this.items) {
            value.add(String.valueOf(rsl));
        }
        return value.toString();
    }

    public static void main(String[] args) {
        SimpleArray<String> words = new SimpleArray<>(new String[]{"first", "second", "third", "fourth", "fifth" },5);

        System.out.println(words);
        words.add("sixth");
        System.out.println(words);
        words.remove(3);
        System.out.println(words);
        System.out.println(words.get(3));
        words.set(3, "forth");
        System.out.println(words);

        while (words.iterator().hasNext()) {
            System.out.println(words.iterator().next());
        }
    }
}
