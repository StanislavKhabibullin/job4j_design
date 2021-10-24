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
        Report engine = new ReportForHRClass(store);
        String result = "Name; Salary"
                + System.lineSeparator()
                + worker2.getName() + ";"
                + worker2.getSalary() + ";"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(ter -> true), is(result));
    }


    @Test
    public void whenAccountGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForAccountersClass(store);
        StringBuilder result = new StringBuilder();
        result.append("Name; Hired; Fired; FixedSalary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getSalary()).append("$;");
        assertThat(engine.generate(ter -> true), is(result.toString()));
    }

    @Test
    public void whenProgrammerGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForProgrammerClass(store);
        StringBuilder result = new StringBuilder();
        result.append("<!DOCTYPE HTML PUBLIC \"-/" + "/W3C/" + "/DTD HTML 4.01/" + "/EN\" \n"
                + " \"http://www.w3.org/TR/html4/strict.dtd\">")
                .append(System.lineSeparator())
                .append("<h1>Name; Hired; Fired; FixedSalary</h1>")
                .append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getSalary()).append("$;</p>");
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