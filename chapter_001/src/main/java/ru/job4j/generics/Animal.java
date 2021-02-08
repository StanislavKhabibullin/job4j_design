package ru.job4j.generics;

public class Animal {
    private String kindOfAnimal;

    public Animal() {
        this.kindOfAnimal = "NoAnimal";
    }

    public Animal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "kindOfAnimal='" + kindOfAnimal + '\''
                + '}';
    }
}
