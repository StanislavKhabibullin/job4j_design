package serialization;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person_POJO_to_JSon {
    private final boolean sex;
    private final int age;
    private final Contact_POJO contact;
    private final String[] statuses;

    public Person_POJO_to_JSon(boolean sex, int age, Contact_POJO contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact_POJO getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        List<String> statuses = new ArrayList<>();
        statuses.add("married");
        statuses.add("divorced");
        JSONArray jsonStatuses = new JSONArray(statuses);


        final Person_POJO_to_JSon person = new Person_POJO_to_JSon(true, 30,
                new Contact_POJO("+7(924)111-111-11-11"), "Worker", "Married");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", person.getContact());
        jsonObject.put("statuses", person.getStatuses());

        System.out.println(jsonObject);


        System.out.println(new JSONObject(person).toString());




    }

}
