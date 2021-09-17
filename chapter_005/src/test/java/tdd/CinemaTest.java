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
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(Session -> true);
        assertThat(sessions, is(Arrays.asList(session)));

    }

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2021, Calendar.AUGUST, 16, 21, 0);
        Ticket ticket = cinema.buy(account, 1, 1, calendarDate);
        assertThat(ticket, is(new Ticket3D(account, 1, 1, calendarDate)));
    }

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(t -> t.equals(session));
        assertThat(sessions.get(0), is(session));

    }
}