package solid.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.*;


@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable {

    public Employee() {
    }

    @XmlAttribute
    private String name;

    @XmlAttribute
    private Calendar hired;

    @XmlAttribute
    private Calendar fired;

    @XmlAttribute
    private double salary;

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return  Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hired=" + hired +
                ", fired=" + fired +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) throws JAXBException {
        Calendar now = Calendar.getInstance();
        final Employee person = new Employee("Rick", now, now, 155);
        final Employee person1 = new Employee("Morty", now, now, 551);
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(person);
        employeeList.add(person1);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File resultFile = new File("./bookJAXB.xml");

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person,
                    resultFile);
            marshaller.marshal(person1,
                    resultFile);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
    }
}
