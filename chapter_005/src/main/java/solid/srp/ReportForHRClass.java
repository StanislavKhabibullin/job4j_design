package solid.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHRClass implements Report {
    private Store store;

    public ReportForHRClass(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> result = store.findBy(filter);
        text.append("Name; Salary");
        text.append(System.lineSeparator());
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());
            }
        };
        Collections.sort(result, comparator);
        for (Employee employee
                :result) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return String.valueOf(text);
    }
}
