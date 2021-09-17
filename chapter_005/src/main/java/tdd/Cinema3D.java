package tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cinema3D implements Cinema {
    List<Session> mas = new ArrayList<>();
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return mas.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {

        return new Ticket3D(account, row, column, date);
    }

    @Override
    public void add(Session session) {
        mas.add(session);
    }
}
