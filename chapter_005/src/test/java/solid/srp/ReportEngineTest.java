package solid.srp;

import org.junit.Test;

import java.util.Calendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 105);
        store.add(worker);
        store.add(worker2);
        ReportForHRClass engine = new ReportForHRClass(store);
        StringBuilder result = new StringBuilder();
        result.append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(ter -> true), is(result.toString()));
    }


    @Test
    public void whenAccountGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportForAccountersClass engine = new ReportForAccountersClass(store);
        StringBuilder result = new StringBuilder();
        result.append("Name; Hired; Fired; FixedSalary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(ter -> true), is(result.toString()));
    }

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder result = new StringBuilder();
        result.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(ter -> true), is(result.toString()));
    }
}