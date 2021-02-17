package ru.job4j.statistic;

import java.util.*;

public class Analize {

    public Info dif(List<User> previous, List<User> changed) {
        Info rsl = new Info();
        int scratch = 0;
        Collections.sort(previous);
        Collections.sort(changed);
        for (User userPrev:
             previous) {
            for (User userChange:
                 changed) {
                if (userPrev.id == userChange.id) {
                    if (!userChange.name.equals(userPrev.name)) {
                        rsl.changed++;
                    }
                    break;
                }
                scratch++;
            }
            if (scratch == changed.size()) {
                rsl.deleted++;
            }
            scratch = 0;
        }

        for (User userChange:
             changed) {
            scratch = 0;
            for (User userPrev:
                 previous) {
                if (userChange.id == userPrev.id) {
                    break;
                }
                scratch++;
            }
            if (scratch == previous.size()) {
                rsl.aded++;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Mik"));
        prev.add(new User(2, "Mik2"));
        prev.add(new User(3, "Mik3"));
        prev.add(new User(4, "Mik4"));
        prev.add(new User(5, "Mik5"));

        List<User> chan = new ArrayList<>();
        chan.add(new User(1, "Mik"));
        chan.add(new User(2, "Mika"));
        chan.add(new User(3, "Mik3"));
        chan.add(new User(6, "Mik"));
        chan.add(new User(8, "Mik"));
        Analize pres = new Analize();
        Info result = pres.dif(prev, chan);
        System.out.println(result);
    }
}
