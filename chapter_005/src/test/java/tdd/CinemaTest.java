package tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CinemaTest {

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(Session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));

    }

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2021, Calendar.AUGUST, 16, 21, 0);
        Ticket ticket = cinema.buy(account, 1, 1, calendarDate);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(t -> t.equals(new Session3D()));
        assertThat(sessions.get(0), is(new Session3D()));

    }
}