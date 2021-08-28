package solid.srp;

import java.util.function.Predicate;

public interface ReportForHr {
    String generateForHr(Predicate<Employee> filter);
}
