package solid.srp;


import java.util.List;
import java.util.function.Predicate;

public class ReportForAccountersClass implements Report {
    private Store store;

    public ReportForAccountersClass(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
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
}
