package solid.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXMLformat implements Report, Serialisator {
    private Store store;
    public File xtemp;



    public ReportXMLformat(Store store) {
        this.store = store;
    }

    @Override
    public String serialisat(List<Employee> list) throws JAXBException {
        StringBuilder text = new StringBuilder();

            File resultFile = new File("./bookJAXB.xml");
            xtemp = resultFile;
            Employees mas = new Employees(list);
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(mas, xtemp);

        return String.valueOf(text);
    }

    @Override
    public List<Employee> deserialisat() throws JAXBException {
        List<Employee> resultAfterSeri = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Employees result = (Employees) unmarshaller.unmarshal(xtemp);
        resultAfterSeri = result.getEmployees();
        for (Employee empl:
             resultAfterSeri) {
            System.out.println(empl);
        }

        return resultAfterSeri;
    }



    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> result = store.findBy(filter);
        try {
            return serialisat(result);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        store.add(new Employee("Nick", now, now, 125));
        store.add(new Employee("Nicklodeon", now, now, 136));
        ReportXMLformat rep = new ReportXMLformat(store);
        System.out.println(rep.generate(ter -> true));
        rep.deserialisat();
    }

    @XmlRootElement(name = "Employees")
    public static class Employees{
        @XmlElement(name = "Employer")
        private List<Employee> employees;

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }

        public Employees() {
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(ArrayList<Employee> employees) {
            this.employees = employees;
        }
    }
}


