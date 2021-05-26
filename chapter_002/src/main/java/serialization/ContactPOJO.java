package serialization;

public class ContactPOJO {
    private final String phone;

    public String getPhone() {
        return phone;
    }

    public ContactPOJO(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
