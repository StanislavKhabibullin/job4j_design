package ru.job4j.email;

import java.util.List;
import java.util.Objects;
import java.util.Set;
//используемый класс
public class ResultMails {
    private String name;
    private Set<String> nameAdress;

    public ResultMails(String name, Set<String> nameAdress) {
        this.name = name;
        this.nameAdress = nameAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getNameAdress() {
        return nameAdress;
    }

    public void setNameAdress(Set<String> nameAdress) {
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResultMails)) {
            return false;
        }
        ResultMails that = (ResultMails) o;
        return getName().equals(that.getName())
                && getNameAdress().equals(that.getNameAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNameAdress());
    }
}
