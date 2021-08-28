package solid.srp;

import java.util.function.Predicate;

public interface ReportForAccounters {
    String generateAccount(Predicate<Employee> filter);
}
