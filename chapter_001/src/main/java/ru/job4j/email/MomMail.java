package ru.job4j.email;

import java.util.*;
import java.util.stream.Collectors;

public class MomMail {
    private List<resultMails> rsl = new ArrayList<>();
    private List<resultMails> result = new ArrayList<>();

    public List<resultMails> connect(List<UserMails> inner) {
        for (int i = 0; i < inner.size(); i++) {
            List<String> list = new ArrayList<>();
            for (String s : inner.get(i).getUserMail().split(",")) {
                list.add(s);
            }
            rsl.add(new resultMails(inner.get(i).getUserName(), list));
        }
        boolean schet = true;
        for (int i = 0; i < rsl.size(); i++) {
            for (int j = 0; j < rsl.get(i).getNameAdress().size(); j++) {
                for (int k = i + 1; k <rsl.size() ; k++) {
                    for (int l = 0; l < rsl.get(k).getNameAdress().size(); l++) {
                        if (rsl.get(i).getNameAdress().get(j).equals(rsl.get(k).getNameAdress().get(l))) {
                           schet = false;
                        }
                    }

                }
            }
            if (schet == true) {
                result.add(rsl.get(i));
            }
            schet = true;
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
        List<resultMails> res = new ArrayList<>();
        res.addAll(mailik.connect(listik));
        for (resultMails user:
             res) {
            System.out.println(user);
        }
    }

}
