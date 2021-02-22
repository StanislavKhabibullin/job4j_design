package ru.job4j.email;

import java.util.List;
import java.util.Objects;

public class resultMails {
    private String name;
    private List<String> nameAdress;

    public resultMails(String name, List<String> nameAdress) {
        this.name = name;
        this.nameAdress = nameAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNameAdress() {
        return nameAdress;
    }

    public void setNameAdress(List<String> nameAdress) {
        this.nameAdress = nameAdress;
    }

    @Override
    public String toString() {
        return "resultMails{"
                + "name='" + name + '\''
                + ", nameAdress=" + nameAdress
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof resultMails)) return false;
        resultMails that = (resultMails) o;
        return getName().equals(that.getName()) &&
                getNameAdress().equals(that.getNameAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNameAdress());
    }
}
