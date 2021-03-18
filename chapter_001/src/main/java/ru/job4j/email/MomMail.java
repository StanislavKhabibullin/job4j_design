package ru.job4j.email;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
// экзаменационный файл
public class MomMail {
    private Map<String, Set<String>> rsl = new HashMap<>();
    private Map<String, Set<String>> result = new LinkedHashMap<>();
    boolean schet = true;
    public Map<String, Set<String>> connect(List<UserMails> inner) {
        for (int i = 0; i < inner.size(); i++) {
            Set<String> list = new HashSet<>();
            for (String s : inner.get(i).getUserMail().split(",")) {
                list.add(s);
            }
            rsl.put(inner.get(i).getUserName(), list);
        }

        for (Entry<String, Set<String>> entry : rsl.entrySet()) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            for (Entry<String, Set<String>> entryres
                    : result.entrySet()){
                Set<String> valueRes = entryres.getValue();
                for (String mail:
                     valueRes) {
                    if (value.contains(mail)) {
                        valueRes.addAll(value);
                        schet = false;
                        break;
                    }
                }
            }
            if (schet) {
                result.put(key, value);
            } else {
                schet = true;
            }



        }

        return result;
    }

    public static void main(String[] args) {
        MomMail mailik = new MomMail();
        UserMails user1 = new UserMails("user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        UserMails user2 = new UserMails("user2", "foo@gmail.com,ups@pisem.net");
        UserMails user3 = new UserMails("user3", "xyz@pisem.net,vasya@pupkin.com");
        UserMails user4 = new UserMails("user4", "ups@pisem.net,aaa@bbb.ru");
        UserMails user5 = new UserMails("user5", "xyz@pisem.net");
        List<UserMails> listik = List.of(user1, user2, user3, user4, user5);
        Map<String, Set<String>> res = new HashMap<>();
        res.putAll(mailik.connect(listik));
        for (Map.Entry user
                :res.entrySet())
            System.out.println(user.getKey() + "   " + user.getValue());
        Map <String, String> books = new HashMap<>();
        books.put("Война и мир", "Лев Толстой");
        books.put("Преступление и наказание", "Федор Достоевский");
        books.put("Философия Java", "Брюс Эккель");
        books.put("Братья Карамазовы", "Федор Достоевский");
        books.put("Властелин Колец", "Джон Толкин");

        books.merge("Философия Java", "Брюс Эккель", (a, b) -> b +  " и кто-то там еще");
        books.forEach((a,b) -> System.out.println("Название:" + a + ". Автор: " + b));
    }

}
