package ru.job4j.generics;

import java.util.*;

public class SimpleArray<T> {
    private List<T> mas;

    public SimpleArray(List<T> mas) {
        this.mas = mas;
    }

    public List<T> getMas() {
        return mas;
    }

    public void setMas(List<T> mas) {
        this.mas = mas;
    }

    public List<T> add(T model) {
        List<T> mas1 = new ArrayList<>();
        for (int i = 0; i < this.mas.size(); i++) {
            mas1.add(mas.get(i));
        }
        mas1.add(model);
        this.mas = mas1;
        return mas1;
    }

    public List<T> set(int index, T model) {
        this.mas.set(index, model);
        return mas;
    }

    public List<T> remove(int index) {
        List<T> mas1 = new ArrayList<>();
        for (int i = 0; i < this.mas.size(); i++) {
            if (i != index) {
                mas1.add(this.mas.get(i));
            }
        }
        this.mas = mas1;
    return mas1;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.mas.size());
        for (int i = 0; i < this.mas.size(); i++) {
            if (i == index) {
                return mas.get(i);
            }
        }
        return null;
    }

    public List<Integer> iterator() {
        List<Integer> rsl = new ArrayList<>();
        for (int i = 0; i < this.mas.size(); i++) {
            rsl.add(i);
        }
        return rsl;
    }

    public static void main(String[] args) {
        SimpleArray<String> words = new SimpleArray<>(
                List.of("first", "second", "third", "fourth", "fifth")
        );
        System.out.println(words.getMas());
        words.add("sixth");
        System.out.println(words.getMas());
        words.remove(3);
        System.out.println(words.getMas());
        System.out.println(words.get(3));
        words.set(3, "forth");
        System.out.println(words.getMas());
    }
}
