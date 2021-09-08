package solid.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
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
                    .append(employee.getSalary()).append(";")
            .append(System.lineSeparator());
        }
        return String.valueOf(text);
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 105);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportForHRClass(store);
        System.out.println(engine.generate(tr -> true));
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(worker));
    }
}
