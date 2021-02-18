package ru.job4j.statistic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class AnalizeTest {

    @Test
    public void difWhenDelete() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Mik"));
        prev.add(new User(2, "Mik2"));
        prev.add(new User(3, "Mik3"));
        prev.add(new User(4, "Mik4"));
        prev.add(new User(5, "Mik5"));

        List<User> chan = new ArrayList<>();
        chan.add(new User(1, "Mik"));
        chan.add(new User(2, "Mik2"));
        chan.add(new User(3, "Mik3"));
        Analize pres = new Analize();
        Info result = pres.difMap(prev, chan);
        assertThat(result.deleted, is(2));
    }

    @Test
    public void difWhenChange() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Mik"));
        prev.add(new User(2, "Mik2"));
        prev.add(new User(3, "Mik3"));
        prev.add(new User(4, "Mik4"));
        prev.add(new User(5, "Mik5"));

        List<User> chan = new ArrayList<>();
        chan.add(new User(1, "Mik"));
        chan.add(new User(2, "Mik2"));
        chan.add(new User(3, "Mik3"));
        chan.add(new User(4, "Mik3"));
        Analize pres = new Analize();
        Info result = pres.difMap(prev, chan);
        assertThat(result.deleted, is(1));
        assertThat(result.changed, is(1));
    }
    @Test
    public void difWhenChangeDeleteAded() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Mik"));
        prev.add(new User(2, "Mik2"));
        prev.add(new User(3, "Mik3"));
        prev.add(new User(4, "Mik4"));
        prev.add(new User(5, "Mik5"));

        List<User> chan = new ArrayList<>();
        chan.add(new User(1, "Mik"));
        chan.add(new User(2, "Mik2"));
        chan.add(new User(3, "Mik3"));
        chan.add(new User(4, "Mik3"));
        chan.add(new User(6, "Mik3"));
        chan.add(new User(7, "Mik3"));
        Analize pres = new Analize();
        Info result = pres.difMap(prev, chan);
        assertThat(result.deleted, is(1));
        assertThat(result.changed, is(1));
        assertThat(result.aded, is(2));
    }

}