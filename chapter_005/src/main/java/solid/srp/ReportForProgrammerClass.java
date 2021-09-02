package solid.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportForProgrammerClass implements Report {
    private Store store;

    public ReportForProgrammerClass(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> result = store.findBy(filter);
        text.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \n" +
                " \"http://www.w3.org/TR/html4/strict.dtd\">");
        text.append(System.lineSeparator());
        text.append("<h1>Name; Hired; Fired; FixedSalary</h1>");
        text.append(System.lineSeparator());
        for (Employee employee
                :result) {
            text.append("<p>").append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append("$;</p>");
        }
        return String.valueOf(text);
    }
}
