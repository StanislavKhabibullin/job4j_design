package ru.job4j.email;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MomMailTest {

    @Test
    public void connect() {
        MomMail mailik = new MomMail();
        UserMails user1 = new UserMails("user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        UserMails user2 = new UserMails("user2", "foo@gmail.com,ups@pisem.net");
        UserMails user3 = new UserMails("user3", "xyz@pisem.net,vasya@pupkin.com");
        UserMails user4 = new UserMails("user4", "ups@pisem.net,aaa@bbb.ru");
        UserMails user5 = new UserMails("user5", "xyz@pisem.net");
        List<UserMails> listik = List.of(user1, user2, user3, user4, user5);
        List<resultMails> res = new ArrayList<>();
        res.addAll(mailik.connect(listik));
        resultMails user4_res = new resultMails("user4", List.of("ups@pisem.net", "aaa@bbb.ru"));
        resultMails user5_res = new resultMails("user5", List.of("xyz@pisem.net"));
        List<resultMails> expect = List.of(user4_res, user5_res);
        assertThat(res, is(expect));
    }
}