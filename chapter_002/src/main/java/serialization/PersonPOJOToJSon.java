package serialization;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonPOJOToJSon {
    private final boolean sex;
    private final int age;
    private final ContactPOJO contact;
    private final String[] statuses;

    public PersonPOJOToJSon(boolean sex, int age, ContactPOJO contact, String... statuses) {
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

    public ContactPOJO getContact() {
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
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-777-11-11\"}");

        List<String> statuses = new ArrayList<>();
        statuses.add("married");
        statuses.add("divorced");
        JSONArray jsonStatuses = new JSONArray(statuses);


        final PersonPOJOToJSon person = new PersonPOJOToJSon(true, 30,
                new ContactPOJO("+7(924)111-111-11-11"), "Worker", "Married");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject);


        System.out.println(new JSONObject(person).toString());




    }

}
