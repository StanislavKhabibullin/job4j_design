package solid.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {
    public final List<Employee> res = new ArrayList<>();

    public Employee add(Employee am) {
        res.add(am);
        return am;
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return res.stream().filter(filter).collect(Collectors.toList());
    }
}
