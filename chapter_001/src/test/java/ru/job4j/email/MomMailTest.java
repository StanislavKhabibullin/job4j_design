package ru.job4j.email;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MomMailTest {

    @Test
    public void connectTest() {
        MomMail mailik = new MomMail();
        UserMails user1 = new UserMails("user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        UserMails user2 = new UserMails("user2", "foo@gmail.com,ups@pisem.net");
        UserMails user3 = new UserMails("user3", "xyz@pisem.net,vasya@pupkin.com");
        UserMails user4 = new UserMails("user4", "ups@pisem.net,aaa@bbb.ru");
        UserMails user5 = new UserMails("user5", "xyz@pisem.net");
        List<UserMails> listik = List.of(user1, user2, user3, user4, user5);
        Map<String, Set<String>> res = new HashMap<>();
        res.putAll(mailik.connect(listik));
        ResultMails user4res;
        user4res = new ResultMails("user1", Set.of("aaa@bbb.ru", "ups@pisem.net", "lol@mail.ru", "xxx@ya.ru", "foo@gmail.com"));
        ResultMails user5res;
        user5res = new ResultMails("user5", Set.of("vasya@pupkin.com", "xyz@pisem.net"));
        Map<String, Set<String>> expect = new LinkedHashMap<>();
        expect.put(user4res.getName(), user4res.getNameAdress());
        expect.put(user5res.getName(), user5res.getNameAdress());
        assertThat(res, is(expect));
    }


}