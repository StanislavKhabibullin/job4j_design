package solid.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSONformat implements Report {
    private Store store;
    public File xtemp;

    public ReportJSONformat(Store store) {
        this.store = store;
    }

    public String serializeToJSON(List<Employee> list) {

        StringBuilder text = new StringBuilder();
        Gson gson = new GsonBuilder().create();
        try {
            File templeFile = new  File("./bookJSON.txt");
            xtemp = templeFile;
            try (FileOutputStream fos = new FileOutputStream(templeFile);
                 ObjectOutputStream ois = new ObjectOutputStream(fos)) {

                var lib = gson.toJson(list);
                text.append(lib);
                ois.writeObject(lib);

            }
        } catch (EOFException exc) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(text);
    }
/**
    public List<Employee> deSerializeFromJSON() {
        List<Employee> resultAfterSeri = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(xtemp);
             ObjectInputStream oisJ = new ObjectInputStream(fis)) {
            Employee res;
            Gson promRes = new GsonBuilder().create();
            while (true) {
                final String employeeJson = (String) oisJ.readObject();
                res = promRes.fromJson(employeeJson, Employee.class);
                System.out.println("resultAfterDeserialisator - " + res);
                resultAfterSeri.add(res);
            }
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultAfterSeri;
    }

 */




    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> result = store.findBy(filter);
        String text = serializeToJSON(result);
        /**
         *  deSerializeFromJSON();
         */
        return text;
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 105);
        Employee worker3 = new Employee("Ivanna", now, now, 501);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportJSONformat(store);
        System.out.println(engine.generate(tr -> true));

    }
}
