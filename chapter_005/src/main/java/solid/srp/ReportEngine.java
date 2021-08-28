package solid.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report, ReportForAccounters, ReportForHr {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generateForHr(Predicate<Employee> filter) {
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

    @Override
    public String generateAccount(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> result = store.findBy(filter);
        text.append("Name; Hired; Fired; FixedSalary");
        text.append(System.lineSeparator());
        for (Employee employee
                :result) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return String.valueOf(text);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> result = store.findBy(filter);
        text.append("Name; Hired; Fired; Salary");
        text.append(System.lineSeparator());
        for (Employee employee
                :result) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return String.valueOf(text);
    }
}
