package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SimpleArray<T> {
   private T[] items;
   private int count;

   public SimpleArray(int size) {
      this.items = (T[]) new Object[size];
      count = size;
   }

    public SimpleArray(T[] items, int count) {
        this.items = items;
        this.count = count;
    }

    public T[] add(T model) {
        T[] mas1 = (T[]) new Object[this.items.length + 1];
        for (int i = 0; i < this.items.length; i++) {
           if (items[i] == null) {
               mas1[i] = model;
               model = null;
               continue;
           }
            mas1[i] = items[i];
        }
        mas1[this.items.length] = model;
        this.items = mas1;
        count = mas1.length;
        return mas1;
    }

    public T[] set(int index, T model) {
       Objects.checkIndex(index, count);
       this.items[index] = model;
        return items;
    }

    public T[] remove(int index) {
       Objects.checkIndex(index, count);
        T[] mas1 = (T[]) new Object[this.items.length - 1];
        int j = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (i != index) {
                mas1[j++] = items[i];
            }
        }
        this.items = mas1;
        count--;
    return mas1;
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

    public Iterator<T> iterator() {
        List<T> rsl = new ArrayList<>();
        for (int i = 0; i < this.items.length; i++) {
            rsl.add(items[i]);
        }
        return rsl.iterator();
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
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
